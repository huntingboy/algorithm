package com.nomad.xz.hw;

/**
 * @author nomad
 * @create 2020-09-15 8:14 PM
 */
public class TestBinding {
    public static void main(String[] args) {
        Parent p = new Son();
        System.out.println(p.name);
        System.out.println(((Son)p).name);
        p.printName();
        p.printName2(); //注释p里的printName2方法会报错， 注释掉s里的printName2会执行继承的printName2方法
        p.printName1();
        ((Son)p).printName();
        ((Son)p).printName2();
        ((Son)p).printName1();

        Parent p1 = new Parent();
    }
}

class Parent{
    String name = "parent";

    public void printName(){
        System.out.println("p mathod");
    }

    public void printName1(){
        System.out.println("p mathod1");
    }

    public void printName2(){
        System.out.println("p mathod" + this.getClass());
    }

    private void privatePrint() {
        System.out.println("p private method");
    }
}

class Son extends Parent {
    String name = "son";

    public void printName() {
        System.out.println("s method");
    }

    public void printName2(){
        System.out.println("s method" + this.getClass());
    }

    private void privatePrint(){
        System.out.println("s private method");
    }
}
