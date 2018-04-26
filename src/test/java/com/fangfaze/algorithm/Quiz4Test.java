package com.fangfaze.algorithm;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Quiz4 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>04/26/2018</pre>
 */
public class Quiz4Test {

    // 在一个列表中找出两个数,其和为输入的数字k,要求时间复杂度为o(n)
    /**
     * Method: findIndex(int k)
     */
    @Test
    public void testFindIndex() throws Exception {
        int[] list = {1,2,4,5,2,6,8,9,3,1,3,5,7,8,9,5,2};
        Quiz4 quiz4 = new Quiz4(list);
        quiz4.findIndex(10);

    }


} 
