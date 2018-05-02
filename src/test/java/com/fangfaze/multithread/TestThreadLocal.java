package com.fangfaze.multithread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadLocal extends Thread {

    final static int MAX_THREAD = 3;
    CountDownLatch countDownLatch = new CountDownLatch(MAX_THREAD);

    static ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);
    static AtomicInteger counter_integer = new AtomicInteger(0);
    int localCount = 0;
    static int staticCount = 0;

    void increase() {
        for (int i = 0; i < 100000; ++i) {
            count.set(count.get() + 1);
            counter_integer.getAndIncrement();
            localCount++;
            staticCount++;
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println(count.get());
        System.out.println(counter_integer.get());
        System.out.println(localCount);
        System.out.println(staticCount);
        countDownLatch.countDown();
    }

    @Override
    public void run() {
        increase();
    }

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < MAX_THREAD; ++i) {
            new TestThreadLocal().start();
        }
        countDownLatch.await(1000, TimeUnit.MILLISECONDS);
    }

}
