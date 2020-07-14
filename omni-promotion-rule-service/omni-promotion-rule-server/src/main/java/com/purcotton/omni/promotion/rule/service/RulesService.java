package com.purcotton.omni.promotion.rule.service;
import com.google.gson.Gson;
import com.purcotton.omni.promotion.rule.bean.ExceptionType;
import com.purcotton.omni.promotion.rule.bean.Goods;
import com.purcotton.omni.promotion.rule.bean.Person;
import com.purcotton.omni.promotion.rule.bean.Rules;
import com.purcotton.omni.promotion.rule.dao.RulesDao;
import com.purcotton.omni.promotion.rule.exception.BusinessException;
import org.drools.core.io.impl.ClassPathResource;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
//@Slf4j
public class RulesService  implements InitializingBean {

    @Autowired
    private RulesDao rulesDao;

    private Map<String,Class> dataMaps = new ConcurrentHashMap<String,Class>();
    //规则目录存放地址
    private static final String RULE_PATH="src/main/resources/rules";
    //规则后缀地址
    private static final String RULE_SUFFIX=".drl";

    /**
     * 动态获取KieSession
     * @param rules rule
     * @return KieSession
     */
    public KieSession getKieSession(String rules) {
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kfs = kieServices.newKieFileSystem();
        kfs.write("src/main/resources/rules/rules.drl", rules.getBytes());
        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
        Results results = kieBuilder.getResults();
        if (results.hasMessages(Message.Level.ERROR)) {
            System.out.println(results.getMessages());
            throw new BusinessException(300003,results.getMessages().toString(),4);
        }
        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
        KieBase kieBase = kieContainer.getKieBase();

        return kieBase.newKieSession();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        dataMaps.put("demo", Person.class);
        dataMaps.put("goods_promotation",Goods.class);
        //initRuleFiles();
    }

    public void initRuleFiles(){
        //查询数据库所有的规则
        List<Rules> rulesList =  rulesDao.getRuleList();
        if(rulesList == null||rulesList.size()<0)
            //log.error("================未配置规则，请检查系统配置===================");
        rulesList.forEach(rule->{
            //log.info("==========开始处理规则："+rule.getName()+"========");
            //检测规则目录是否存在
            File file = new File(RULE_PATH);
            if(!file.exists()){
                file.mkdirs();
            }
            StringBuffer sb = new StringBuffer();
            sb.append(RULE_PATH);
            sb.append(File.separator);
            sb.append(rule.getRule_Type());
            sb.append(RULE_SUFFIX);
            try {
                String filePath = new ClassPathResource(sb.toString()).getPath();
                File ruleFile = new File(filePath);
                if(ruleFile.exists()){
                    ruleFile.delete();
                }
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(ruleFile)));
                writer.write(rule.getRule());
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //log.info("========处理规则："+rule.getName()+"结束========");
        });
    }

    /**
     * 动态加载已经部署的rule
     *
     * @param id rule id
     * @param t  对象
     * @return 结果对象
     */
    public Person getRulesWrite(Integer id, Person t) {
        String rules;
        Rules ru = rulesDao.getById(id);
        if (ru != null && ru.getRule() != null) {
            rules = ru.getRule();
        } else throw new BusinessException(ExceptionType.RULE_IS_NULL);

        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kfs = kieServices.newKieFileSystem();
        kfs.write("src/main/resources/rules/rules.drl", rules.getBytes());
        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
        Results results = kieBuilder.getResults();
        if (results.hasMessages(Message.Level.ERROR)) {
            System.out.println(results.getMessages());
            throw new IllegalStateException("### errors ###");
        }
        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
        KieBase kieBase = kieContainer.getKieBase();
        KieSession ksession = kieBase.newKieSession();

        ksession.insert(t);
        ksession.fireAllRules();
        return t;
    }


    /**
     * 动态加载已经部署的rule
     *
     * @param id rule id
     * @param json  对象
     * @return 结果对象
     */
    public Object getRulesWrite(Integer id, String json) {
        String rules;
        Rules ru = rulesDao.getById(id);
        if (ru != null && ru.getRule() != null) {
            rules = ru.getRule();
        } else throw new BusinessException(ExceptionType.RULE_IS_NULL);
        Gson gson = new Gson();
        Object t = gson.fromJson(json, dataMaps.get(ru.getRule_Type()));
        String format = "yyyy-MM-dd";
        System.setProperty("drools.dateformat", format); //指定日期格式，不然会出现日期转换报错
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kfs = kieServices.newKieFileSystem();
        kfs.write("src/main/resources/rules/rules.drl", rules.getBytes());
        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
        Results results = kieBuilder.getResults();
        if (results.hasMessages(Message.Level.ERROR)) {
            System.out.println(results.getMessages());
            throw new IllegalStateException("### errors ###");
        }
        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
        KieBase kieBase = kieContainer.getKieBase();
        KieSession ksession = kieBase.newKieSession();

        ksession.insert(t);
        ksession.fireAllRules();
        return t;
    }

    @Transactional
    public Integer deleteRule(Integer id){
        int count =  rulesDao.deleteRule(id);
        return  count;
    }
}
