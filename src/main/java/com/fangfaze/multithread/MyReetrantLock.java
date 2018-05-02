package com.fangfaze.multithread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyReetrantLock {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static int count = 0;

    public int getCount() {
        return count;
    }


    public void testMethord() {
        final String name = Thread.currentThread().getName();
        for (int i = 0; i < 100000; ++i) {
            Thread.yield();
            lock.readLock().lock();
            count++;
//            System.out.println(name + ":lock");
//            System.out.println(name + ":" + i);
            lock.readLock().unlock();
//            System.out.println(name + ":unlock");
        }
    }

}
