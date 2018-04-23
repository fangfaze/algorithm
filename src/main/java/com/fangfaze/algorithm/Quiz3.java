package com.fangfaze.algorithm;

import java.util.Arrays;

public class Quiz3 {
    //时间复杂度O(n)的排序
    //桶排序,但是无法做到完全

    public Quiz3(int[] list) {
        this.list = list;
    }

    public final int[] list;


    public void sort() {
        final int MAX = 100;
        int[] buckets = new int[MAX];
        for (int i : list) {
            buckets[i]++;
        }

        int index = 0;
        for (int i = 0; i < MAX; ++i) {
            for (int j = 0; j < buckets[i]; ++j) {
                list[index++] = i;
            }
        }
    }
}
