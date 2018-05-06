package com.fangfaze.algorithm;

import java.math.BigInteger;

public class Collatz {
    // 尝试证明
    // 代数必然还有用来描述与3x+1问题有关的重要的新概念,需要定义.
    // 我想是熵, 3x+1的性质与熵的增减有一定的关系. x/2的性质是除去末尾的0.

    private BigInteger bigInteger;

    public Collatz(BigInteger bigInteger) {
        this.bigInteger = bigInteger;
    }

    public void flow() {
        final BigInteger two = new BigInteger("2");
        final BigInteger three = new BigInteger("3");
        while (bigInteger.compareTo(BigInteger.ONE) != 0) {
            BigInteger[] results = bigInteger.divideAndRemainder(two);
            if (results[1].compareTo(BigInteger.ZERO) == 0) {
                bigInteger = results[0];
            } else {
                System.out.println(bigInteger.toString(2));
                bigInteger = bigInteger.multiply(three).add(BigInteger.ONE);
            }
        }
        System.out.println(bigInteger.toString(2));
    }








}
