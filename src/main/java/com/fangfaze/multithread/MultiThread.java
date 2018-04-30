package com.fangfaze.multithread;

public class MultiThread implements Runnable {

    static int count = 0;

    synchronized void increase() {
        count++;
    }

    @Override
    public void run() {

    }

}
