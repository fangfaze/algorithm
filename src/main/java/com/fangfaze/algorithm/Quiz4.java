package com.fangfaze.algorithm;

import java.util.HashMap;
import java.util.Map;

public class Quiz4 {
    //时间复杂度O(n)的排序
    //桶排序,但是无法做到完全

    public Quiz4(int[] list) {
        this.list = list;
    }

    public final int[] list;


    public void findIndex(int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.length; ++i) {
            int x = k / 2 - list[i];
            if (map.containsKey(-x)) {
                System.out.println("find:{" + map.get(-x) + "," + i + "}");
                return;
            } else {
                map.put(x, i);
            }
        }

    }
}
