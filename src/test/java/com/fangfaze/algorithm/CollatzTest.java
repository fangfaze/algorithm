package com.fangfaze.algorithm;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

        Map<BigInteger, BigInteger> map = new HashMap<>();
        for (int i = 1; i < 1000; ++i) {
            BigInteger bigInteger = new BigInteger(String.valueOf(i));
            Collatz collatz = new Collatz(bigInteger);
            BigInteger max = collatz.max();
            if (max.compareTo(bigInteger) >= 0) {
                map.put(max, bigInteger);
            }
        }
        map.forEach((max, index) -> System.out.println(max.toString(2) + "==>" + index.toString(2)));

    }

    @Test
    public void test2() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            stringBuilder.append("1");
            BigInteger bigInteger = new BigInteger(stringBuilder.toString(), 2);
            Collatz collatz = new Collatz(bigInteger);
            collatz.flow(2);
        }


    }

    @Test
    public void test3() {
        BigInteger bigInteger = new BigInteger("1");
        for (int i = 0; i < 100; ++i) {
            bigInteger = bigInteger.add(bigInteger);
            System.out.println(bigInteger.toString(3));
        }
    }

}
