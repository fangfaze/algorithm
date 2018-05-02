package com.fangfaze.multithread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TestThreadPoolExecutor {

    private static final int MAX_THREADS = 100;
    private CountDownLatch countDownLatch = new CountDownLatch(MAX_THREADS);

    @Test
    public void test() throws InterruptedException {
//        Executor executor = Executors.newSingleThreadExecutor();
//        Executor executor = Executors.newFixedThreadPool(3);
//        Executor executor = Executors.newCachedThreadPool();
        Executor executor = Executors.newScheduledThreadPool(3);
        Runnable runnable = () -> {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        };

        for (int i = 0; i < MAX_THREADS; ++i) {
            executor.execute(runnable);
        }
        countDownLatch.await();
    }
}
