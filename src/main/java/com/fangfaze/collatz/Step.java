package com.fangfaze.collatz;

import java.math.BigInteger;

public class Step {

    private BigInteger value;
    private BigInteger next;
    private final BigInteger TWO = new BigInteger("2");
    private final BigInteger THREE = new BigInteger("3");

    private boolean odd;

    private Step() {
    }

    public Step(BigInteger value) {
        this.value = value;
        BigInteger[] bigIntegers = value.divideAndRemainder(TWO);
        if (bigIntegers[1].compareTo(BigInteger.ZERO) == 0) {
            next = bigIntegers[0];
            odd = false;
        } else {
            next = value.multiply(THREE).add(BigInteger.ONE);
            odd = true;
        }
    }


    public boolean isOne() {
        return value.compareTo(BigInteger.ONE) == 0;
    }

    public boolean isOdd() {
        return odd;
    }

    public BigInteger getValue() {
        return value;
    }

    public BigInteger getNext() {
        return next;
    }
}
