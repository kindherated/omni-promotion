package com.purcotton.omni.promotion.rule.rule.rule1;

import com.purcotton.omni.promotion.rule.bean.Goods;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

/**
 * 直接指定对应的.drl文件来实现调用
 * 这种方式可以做到精准匹配
 */
public class Test1 {
    public static void main(final String[] args) {
        KieHelper kieHelper = new KieHelper();
        String format = "yyyy-MM-dd";
        System.setProperty("drools.dateformat", format); //指定日期格式，不然会出现日期转换报错
        kieHelper.addResource(ResourceFactory.newClassPathResource("com/xu/drools/rule/rule1/test.drl_bak"), ResourceType.DRL);
        KieSession kieSession = kieHelper.build().newKieSession();
        Goods g = new Goods();
        g.setAmount(4);
        g.setPrice(100d);
        kieSession.insert(g);
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println(g);
    }
}