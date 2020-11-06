package com.nomad.xz.mt;

import java.util.concurrent.CountDownLatch;

/**
 * @author nomad
 * @create 2020-08-31 10:40 AM
 */
public class MyThread extends Thread {

    //AtomicInteger x = new AtomicInteger(0);
    //int x = 0;
    static int x = 0;
    //volatile int x = 0;
    static CountDownLatch cdl = new CountDownLatch(2);

    public void run() {

        for (int i = 0; i < 100; i++) {
            /*synchronized (this) {

                //System.out.println(x.getAndIncrement());
                System.out.println(++x);
            }*/
            x++;
            //System.out.println(x);
            //x.getAndIncrement();
            //System.out.println(x.getAndIncrement());
        }

        cdl.countDown();
    }


    public static void main(String[] args) throws InterruptedException {
        {

            new MyThread().start();

            new MyThread().start();

            cdl.await();

            //System.out.println(new MyThread().x.get());
            System.out.println(new MyThread().x);
        }
    }
}