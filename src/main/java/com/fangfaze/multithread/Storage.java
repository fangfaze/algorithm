package com.fangfaze.multithread;

public class Storage {
    private final int MAX_STORAGE = 10;
    int goods = 0;

    synchronized public void add() throws InterruptedException {
        if (goods >= MAX_STORAGE) {
            System.out.println("满仓等待");
            wait();
            System.out.println("满仓等待~结束");
        }
        goods++;
        System.out.println("生产了:" + goods);
        notifyAll();
    }

    synchronized public void reduce() throws InterruptedException {
        if (goods <= 0) {
            System.out.println("空仓等待");
            wait();
            System.out.println("空仓等待~结束");
        }
        goods--;
        System.out.println("消费了:" + goods);
        notifyAll();
    }
}
