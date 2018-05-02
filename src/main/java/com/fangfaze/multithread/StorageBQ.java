package com.fangfaze.multithread;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StorageBQ {
    private final int MAX_STORAGE = 10;
    private Lock lock = new ReentrantLock();
    BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(MAX_STORAGE);

    public void add(int x) throws InterruptedException {
        blockingQueue.offer(x, 100, TimeUnit.MILLISECONDS);

        lock.lock();
        System.out.print(Thread.currentThread().getName());
        System.out.print("=>" + x + ":");
        queue();
        System.out.println();
        lock.unlock();
    }

    public int reduce() throws InterruptedException {
        int x = blockingQueue.poll(100, TimeUnit.MILLISECONDS);
        lock.lock();
        System.out.print(Thread.currentThread().getName());
        queue();
        System.out.print(":=>" + x);
        System.out.println();
        lock.unlock();
        return x;
    }

    private void queue() {
        for (Iterator<Integer> iterator = blockingQueue.iterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + ",");
        }
    }

}
