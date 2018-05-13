package com.fangfaze.collatz;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Rule Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>05/12/2018</pre>
 */
public class RuleTest {

    @Test
    public void testFlow() throws Exception {
        BigInteger bigInteger = new BigInteger("11111111", 2);
        List<Step> steps = Rule.flow(bigInteger);

        for (Step step : steps) {
            if (step.isOdd()) {
                System.out.println(step.getValue().toString(2));
            }
        }
    }

    @Test
    public void testAnaglize() throws Exception {
        BigInteger bigInteger = new BigInteger("11111", 2);
        Rule.anaglize(bigInteger).forEach(System.out::println);


    }

    @Test
    public void testWhat() throws Exception {
        final BigInteger maxInt = new BigInteger("111111111111111111111111111111111111111", 2);
        BigInteger bigInteger = BigInteger.ZERO;
        Map<String, Integer> results = new HashMap<>();
        Map<Integer, BigInteger> map = new HashMap<>();
        while (bigInteger.compareTo(maxInt) < 0) {
            bigInteger = bigInteger.add(BigInteger.ONE);

            int max = 0;
            for (Step step = new Step(bigInteger); !step.isOne(); step = new Step(step.getNext())) {
                final String str = step.getValue().toString(2);
                if (results.containsKey(str)) {
                    int what = results.get(str);
                    max = max > what ? max : what;
                    break;
                }
                int count = Rule.getMax1(str);
                max = max > count ? max : count;
                results.put(str, max);
            }
            if (!map.containsKey(max)) {
                map.put(max, bigInteger);
                System.out.println(bigInteger.toString(2) + ":" + max);
            }
        }

    }

    @Test
    public void testGetMax1() {
        System.out.println(Rule.getMax1("10000000000000000"));
    }

}
