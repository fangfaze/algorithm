package com.fangfaze.algorithm;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

/**
 * Quiz3 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>04/23/2018</pre>
 */
public class Quiz3Test {

    /**
     * Method: sort()
     */
    @Test
    public void testSort() throws Exception {
        int[] list = {1, 2, 40, 3, 92, 42, 1};
        Quiz3 q3 = new Quiz3(list);
        System.out.println(Arrays.toString(q3.list));
        q3.sort();
        System.out.println(Arrays.toString(q3.list));
    }
}
