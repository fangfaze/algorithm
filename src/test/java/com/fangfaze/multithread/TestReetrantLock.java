package com.fangfaze.multithread;

import org.junit.Test;

public class TestReetrantLock {

    @Test
    public void test() throws Exception {

        MyReetrantLock myReetrantLock = new MyReetrantLock();
        Thread t1 = new Thread(() -> myReetrantLock.testMethord());
        Thread t2 = new Thread(() -> myReetrantLock.testMethord());
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(myReetrantLock.getCount());

    }


}
