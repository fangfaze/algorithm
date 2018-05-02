package com.fangfaze.multithread;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * StorageBQ Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>05/02/2018</pre>
 */
public class StorageBQTest {
    StorageBQ storageBQ = new StorageBQ();
    static AtomicInteger count = new AtomicInteger(0);
    //    static ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);
    Random random = new Random(System.currentTimeMillis());

    private void add() {
        try {
            Thread.sleep(random.nextInt(20));
            int i = count.getAndIncrement();
            storageBQ.add(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }

    private void reduce() {
        try {
            Thread.sleep(random.nextInt(30));
            storageBQ.reduce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }

    final int THREADS = 1000;
    CountDownLatch countDownLatch = new CountDownLatch(THREADS * 2);

    @Test
    public void testAdd() throws Exception {
        for (int i = 0; i < THREADS; ++i) {
            new Thread(this::add).start();
            new Thread(this::reduce).start();
        }
        countDownLatch.await(10000, TimeUnit.MILLISECONDS);
    }

} 
