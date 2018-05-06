package com.fangfaze.algorithm;

//验证角谷定理
public class Quiz2 {
    private int n;

    public Quiz2(int n) {
        this.n = n;
    }

    public void flow() {
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                System.out.println(Integer.toBinaryString(n));
                n = 3 * n + 1;
            }
        }
        System.out.println(Integer.toBinaryString(n));
    }

}
