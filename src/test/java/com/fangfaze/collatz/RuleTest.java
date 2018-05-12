package com.fangfaze.collatz;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.math.BigInteger;
import java.util.List;

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
        BigInteger bigInteger = new BigInteger("11", 2);
        List<Step> steps = Rule.flow(bigInteger);

        for (Step step : steps) {
            System.out.println(step.getValue().toString(2));
        }
    }

} 
