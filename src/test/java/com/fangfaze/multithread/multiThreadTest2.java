package com.fangfaze.multithread;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * multiThread Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>04/29/2018</pre>
 */
public class multiThreadTest2 {

    private void run1() {
        while (!Thread.interrupted()) {
        }
        System.out.println("exit~normal");
    }

    private void run2() {
        try {
            while (!Thread.interrupted()) {
                Thread.sleep(2000);
            }
            System.out.println("exit~normal");
        } catch (InterruptedException e) {
            System.out.println("exit~interrupt");
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws Exception {
        Thread t1 = new Thread(this::run2);
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        t1.join();

    }

    @Test
    public void test1() throws Exception {

        Random random = new Random(System.currentTimeMillis());
        ExecutorService e = Executors.newFixedThreadPool(3);
        Callable<Integer> callable = () -> {
            Thread.sleep(100);
            return random.nextInt(100);

        };
        Future<Integer> future = e.submit(callable);
        while (!future.isDone()) {
            System.out.println(System.currentTimeMillis());
        }
//        System.out.println(future.get());
    }
}