package com.fangfaze.multithread;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * multiThread Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>04/29/2018</pre>
 */
public class multiThreadTest {


    int THREADS = 3;
    private CountDownLatch countDownLatch = new CountDownLatch(THREADS);


    @Test
    public void testMultiThread() throws InterruptedException {
        Random random = new Random(System.currentTimeMillis());
        Runnable runnable = () -> {
            long now = System.currentTimeMillis();
            System.out.println(Thread.currentThread() + ":" + now);
            try {
                Thread.sleep(900 + random.nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + ":" + (System.currentTimeMillis() - now));
            countDownLatch.countDown();
        };

        for (int i = 0; i < THREADS; ++i) {
            new Thread(runnable).start();
        }
        countDownLatch.await(1000, TimeUnit.MILLISECONDS);
        System.out.println("final");
    }

    @Test
    public void testMultiThread1() throws InterruptedException {

        class MyThread extends Thread {

            final int count;

            MyThread(int count) {
                this.count = count;
            }

            final Object lock = new Object();

            @Override
            public void run() {
                {
                    final String name = Thread.currentThread().getName();
                    System.out.println(name + "~start!");
                    synchronized (MyThread.class) {
                        try {
                            Thread.sleep(count * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(name + "~finish!");
                    countDownLatch.countDown();
                }
            }
        }
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            Thread thread = new MyThread(i);
            thread.start();
            list.add(thread);
        }
        for (Thread thread : list) {
            System.out.println(thread.getName() + "call");
            thread.join();
        }
        System.out.println("final");
    }

    int count = 0;

    synchronized void increase() {
        count++;

    }

    @Test
    public void testMultiThread2() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10000; ++i) {
                increase();
            }
        };

        for (int i = 0; i < THREADS; ++i) {
            new Thread(runnable).start();
        }
        countDownLatch.await(1000, TimeUnit.MILLISECONDS);
        System.out.println(count);

    }

}