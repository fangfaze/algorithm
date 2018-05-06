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
        Collatz collatz = new Collatz(new BigInteger("5678907890806870790675665456125432532454657754665234542123958890"));
        collatz.flow();

    }


} 
