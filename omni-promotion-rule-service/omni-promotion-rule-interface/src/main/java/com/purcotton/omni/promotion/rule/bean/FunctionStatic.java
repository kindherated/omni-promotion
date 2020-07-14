package com.purcotton.omni.promotion.rule.bean;

/**
 * 测试静态方法
 */
public class FunctionStatic {

    public static void function1(){
        System.out.println("输出一个无参无返回函数");
    }

    public static String function2(){
        System.out.println("输出一个无参有返回函数");
        return "hello";
    }

    public  static void function3(String param){
        System.out.println("输出一个有参无返回函数,参数为："+param);
    }

    public  static String function4(String param){
        System.out.println("输出一个有参有返回函数：参数为："+param);
        return "hello";
    }

}
