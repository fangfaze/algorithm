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

    public void flow(int radix) {
        int count = 0;
        int count_2 = 0;
        int count_3 = 0;
        BigInteger max = BigInteger.ZERO;
        final BigInteger two = new BigInteger("2");
        final BigInteger three = new BigInteger("3");
        while (bigInteger.compareTo(BigInteger.ONE) != 0) {
            BigInteger[] results = bigInteger.divideAndRemainder(two);
            if (results[1].compareTo(BigInteger.ZERO) == 0) {
                ++count;
                ++count_2;
                System.out.println(bigInteger.toString(radix) + ":" + count + ":_" + count_2);
                bigInteger = results[0];
            } else {
                BigInteger bigIntegerNew = bigInteger.multiply(three).add(BigInteger.ONE);
                ++count;
                ++count_3;
                System.out.println(bigInteger.toString(radix) + ":" + count + ":^" + count_3);
                if (max.compareTo(bigInteger) < 0) {
                    max = bigInteger;
                }
                bigInteger = bigIntegerNew;
            }
        }
        System.out.println(bigInteger.toString());
    }

    public BigInteger max() {
        int count = 0;
        int count_2 = 0;
        int count_3 = 0;
        BigInteger max = BigInteger.ZERO;
        final BigInteger two = new BigInteger("2");
        final BigInteger three = new BigInteger("3");
        while (bigInteger.compareTo(BigInteger.ONE) != 0) {
            BigInteger[] results = bigInteger.divideAndRemainder(two);
            if (results[1].compareTo(BigInteger.ZERO) == 0) {
                ++count;
                ++count_2;
                bigInteger = results[0];
            } else {
                BigInteger bigIntegerNew = bigInteger.multiply(three).add(BigInteger.ONE);
                ++count;
                ++count_3;
                if (max.compareTo(bigInteger) < 0) {
                    max = bigInteger;
                }
                bigInteger = bigIntegerNew;
            }
        }
        return max;
    }
}
