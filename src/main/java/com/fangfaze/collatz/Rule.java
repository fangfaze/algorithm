package com.fangfaze.collatz;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class Rule {

    public static List<Step> flow(BigInteger bigInteger) {
        List<Step> list = new LinkedList<>();
        Step step = new Step(bigInteger);
        while (!step.isOne()) {
            list.add(step);
            step = new Step(step.getNext());
        }
        return list;
    }
}
