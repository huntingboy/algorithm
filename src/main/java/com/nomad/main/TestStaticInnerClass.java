package com.nomad.main;

/**
 *
 */
public class TestStaticInnerClass {
    public static void main(String[] args) {
        StaticInnerClass.a = "abc";
    }

    class InnerClass{
        private static final String a = "abc"; //必须要有final,否则类要用static修饰
        private String b = "abc";
    }


    static class StaticInnerClass{
        private static String a = "abc";
    }
}
