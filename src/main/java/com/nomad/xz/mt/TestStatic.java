package com.nomad.xz.mt;

/**
 * @author nomad
 * @create 2020-08-05 12:22 AM
 */
public class TestStatic { //静态内部类格式单例模式

    private TestStatic(){
        System.out.println("\"constructor\" = " + "constructor");
    }

    static {
        System.out.println("\"outer static\" = " + "outer static");
    }

    public static TestStatic getInstance(){
        System.out.println("\"getInstance\" = " + "getInstance");
        return Inner.instance;
        //return null;
    }

    private static class Inner { //支持延迟加载

        static {
            System.out.println("\"inner static\" = " + "inner static");
        }

        private static final TestStatic instance = new TestStatic();
    }
}
