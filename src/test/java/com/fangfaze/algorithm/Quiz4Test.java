package com.fangfaze.algorithm;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        int[] list = {1, 2, 4, 5, 2, 6, 8, 9, 3, 1, 3, 5, 7, 8, 9, 5, 2};
        Quiz4 quiz4 = new Quiz4(list);
        quiz4.findIndex(10);
    }

    @Test
    public void testFindX() {
        int[] list = {1, 100, 7, 2, 3, 6, 5, 8, 4};
        System.out.println(findX(list));
    }

    // 从list中找出不符合1~n自然数数列+随机数列中,得到随机的数列
    private int findX(int[] list) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < list.length; ++i) {
            x ^= i;
            y ^= list[i];
        }
        return x ^ y;
    }

} 
