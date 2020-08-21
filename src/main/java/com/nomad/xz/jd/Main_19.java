package com.nomad.xz.jd;

import java.util.ArrayList;

/**
 * @author nomad
 * @create 2020-08-16 10:49 PM
 */
public class Main_19 {

    public static void main(String[] args) throws Exception {
        new Main_19().testThread();
    }

    /**
     * 测试多线程
     * setPriority(1:min_priority, 5默认:mormal_priority, 10:max_priority)，优先级高只是获取cpu几率高
     * join
     * yield放弃当前cpu并进入就绪状态，下次仍可能是它执行
     */
    public static ArrayList<String> list = new ArrayList<>();
    public static void testThread() throws Exception{
        Thread t1 = new Main_19().new MyThread();
        Thread t2 = new Thread(new Main_19().new MyRunnable());
        t1.setPriority(3);
        t2.setPriority(8);
        t1.start();
        t2.start();
        t2.join();

        for (int i = 0; i < 100000; i++) {
            i++;
        }
        list.add("main");

        t1.join();

        for (String s : list) {
            System.out.println(s);
        }
    }

    class MyThread extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 100000; i++) {
                i++;
            }
            list.add("Thread 1");
        }
    }

    class MyRunnable implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 100000; i++) {
                Thread.yield();
                i++;
            }
            list.add("Thread 2");
        }
    }
}
