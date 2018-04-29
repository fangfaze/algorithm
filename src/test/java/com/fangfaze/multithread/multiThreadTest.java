package com.fangfaze.multithread;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;

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


    final int THREADS = 3;

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
} 
