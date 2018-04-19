package com.fangfaze.algorithm;

import java.util.List;

public class Quiz1 {
    /**
     * 给定数组,求子数组最大和
     */

    public Quiz1(int[] list) {
        this.list = list;
    }

    public final int[] list;


    public int max() {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        // 动态规划
        for (int i : list) {
            sum = Math.max(i, i + sum);
            max = Math.max(max, sum);
        }
        return max;
    }
}