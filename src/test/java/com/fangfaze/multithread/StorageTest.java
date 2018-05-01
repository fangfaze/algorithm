package com.fangfaze.multithread;

import com.fangfaze.multithread.Storage;
import org.junit.Test;

import java.util.Random;

/**
 * Storage Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>04/30/2018</pre>
 */
public class StorageTest {

    @Test
    public void testReduce() throws Exception {
        Storage storage = new Storage();

        final Random random = new Random(System.currentTimeMillis());
        Runnable provider = () -> {
            for (int i = 0; i < 1000; ++i) {
//                int wait = random.nextInt(10);
                try {
//                    Thread.sleep(wait);
                    if (!storage.add()) {
                        --i;
                    }
                    Thread.yield();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable customer = () -> {
            for (int i = 0; i < 1000; ++i) {
 //               int wait = random.nextInt(10);
                try {
//                    Thread.sleep(wait);
                    if (!storage.reduce()) {
                        --i;
                    }
                    Thread.yield();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(provider);
        Thread thread2 = new Thread(customer);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();


    }


} 
