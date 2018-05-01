package com.fangfaze.multithread;

public class Storage {
    private final int MAX_STORAGE = 10;
    int goods = 0;

    synchronized public boolean add() throws InterruptedException {
        if (goods >= MAX_STORAGE) {
            wait();
            System.out.println("满仓等待");
            return false;
        }
        goods++;
        System.out.println("生产了:" + goods);
        notifyAll();
        return true;
    }

    synchronized public boolean reduce() throws InterruptedException {
        if (goods <= 0) {
            wait();
            System.out.println("空仓等待");
            return false;
        }
        goods--;
        System.out.println("消费了:" + goods);
        notifyAll();
        return true;
    }
}
