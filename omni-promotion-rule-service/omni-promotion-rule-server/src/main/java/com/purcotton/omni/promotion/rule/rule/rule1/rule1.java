package com.purcotton.omni.promotion.rule.rule.rule1;

import com.purcotton.omni.promotion.rule.bean.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * 使用kmodule的方式调用drools
 * /resources/META-INF/kmodule.xml
 * 缺点：
 * 当一个kmodule.xml下面指定的package目录下有个多个.drl文件时，
 * 会全部都会加载进行匹配一次
 */
public class rule1 {
    public static void main(final String[] args) {
        String format = "yyyy-MM-dd";
        System.setProperty("drools.dateformat", format); //指定日期格式，不然会出现日期转换报错
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        System.out.println(kc.verify().getMessages().toString());
        execute(kc);
    }

    private static void execute(KieContainer kc) {
        KieSession ksession = kc.newKieSession("rule1KS");
        Person p2 = new Person(31, "hua", "handsome");
        ksession.insert(p2);
        ksession.fireAllRules();
        ksession.dispose();
    }
}
