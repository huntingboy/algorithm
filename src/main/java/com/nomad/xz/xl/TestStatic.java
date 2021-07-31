package com.nomad.xz.xl;

public class TestStatic {
    static class P{
        static {
            System.out.println("P static");
        }
        {
            System.out.println("P block");
        }
        public P() {
            System.out.println("P con");
        }
    }

    static class C extends P{
        static {
            System.out.println("C static");
        }
        {
            System.out.println("C block");
        }
        public C() {
            System.out.println("C con");
        }
    }

    public static void main(String[] args) {
        new C();
    }
}
