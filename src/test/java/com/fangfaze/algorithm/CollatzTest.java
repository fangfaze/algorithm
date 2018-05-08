package com.fangfaze.algorithm;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.math.BigInteger;

/**
 * Collatz Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>05/06/2018</pre>
 */
public class CollatzTest {
    /**
     * Method: flow()
     */
    @Test
    public void testFlow() throws Exception {
        BigInteger bigInteger = new BigInteger("111111", 2);
        Collatz collatz = new Collatz(bigInteger);
        collatz.flow();
    }

    @Test
    public void testTest() {
        BigInteger bigInteger1 = BigInteger.ONE;
        for (int i = 0; i < 100; ++i) {
            bigInteger1 = bigInteger1.multiply(new BigInteger("2"));
            System.out.println(bigInteger1.toString(6));
        }
    }
} 
