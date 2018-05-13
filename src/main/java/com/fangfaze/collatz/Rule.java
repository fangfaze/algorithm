package com.fangfaze.collatz;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class Rule {

    public static List<Step> flow(BigInteger bigInteger) {
        List<Step> list = new LinkedList<>();
        for (Step step = new Step(bigInteger); !step.isOne(); step = new Step(step.getNext())) {
            list.add(step);
        }
        return list;
    }


    public static List<String> anaglize(BigInteger bigInteger) {
        List<String> list = new LinkedList<>();
        for (Step step = new Step(bigInteger); !step.isOne(); step = new Step(step.getNext())) {
            if (step.isOdd()) {
                String string = step.getValue().toString(2);
                list.add(string + "=>" + getMax1(string));
            }
        }
        return list;
    }

    public static int what(BigInteger bigInteger) {
        int max = 0;
        for (Step step = new Step(bigInteger); !step.isOne(); step = new Step(step.getNext())) {
            int count = getMax1(step.getValue().toString(2));
            max = max > count ? max : count;
        }
        return max;
    }


    public static int getMax1(String string) {
        char[] chars = string.toCharArray();
        int max = 0;
        int count = 0;
        for (int i = chars.length - 1; i >= 0; --i) {
            if (chars[i] == '1') {
                ++count;
            } else {
                max = max > count ? max : count;
                count = 0;
            }
        }
        max = max >= count ? max : count;
        return max;
    }

}
