package com.nomad.xz.hw;

/**
 * @author nomad
 * @create 2020-08-08 12:09 AM
 */
public class TestStatic {
    public static void main(String[] args) throws ClassNotFoundException {
        /*System.out.println(Test2.a); //JD，如果a没有final修饰输出OKJD，因为Test2不会被执行类初始化(cinit<>)，仅仅加载+连接

        System.out.print(B.c); //C

        System.out.print(B1.c); //AC*/

        /*new Test2();
        new Test2();*/

        ClassLoader classLoader=ClassLoader.getSystemClassLoader();
        Class clazz=classLoader.loadClass("com.nomad.xz.hw.Test2"); //Test2不会被执行类初始化(cinit<>)，仅仅加载+连接
        System.out.print("Test");
        clazz.forName("com.nomad.xz.hw.Test2");//加载+连接+类初始化
    }

}

class Test2 {
    public static final String a = "JD";

    public Test2() {
        System.out.println("constrctor");
    }

    {  //块比构造函数先执行
        System.out.println("block");
    }

    static {
        System.out.println("OK");
    }
}

class A {
    static {
        System.out.print("A");
    }
}

class B extends A {
    static {
        System.out.print("B");
    }

    public final static String c = "C";
}

class A1 {
    public static String c = "C";
    static {
        System.out.print("A");
    }
}

class B1 extends A1{
    static {
        System.out.print("B");
    }
}
