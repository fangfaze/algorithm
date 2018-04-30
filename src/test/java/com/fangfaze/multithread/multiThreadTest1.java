package com.fangfaze.multithread;

import org.junit.Test;

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
public class multiThreadTest1 implements Runnable {


    static int count = 0;

    static void increase() {
        ++count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; ++i) {
            synchronized (multiThreadTest1.class) {
                increase();
            }
        }
    }

    @Test
    public void test() throws InterruptedException {
        Thread thread1 = new Thread(new multiThreadTest1());
        Thread thread2 = new Thread(new multiThreadTest1());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(count);
    }
}