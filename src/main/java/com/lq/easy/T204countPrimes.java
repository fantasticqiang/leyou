package com.lq.easy;

/**
 * @author lq
 * @date 2020-05-28 10:08
 */
public class T204countPrimes {

    public static void main(String[] args) {
        int i = countPrimes(10);
        System.out.println(i);
    }

    /**
     * 计算n以内的质数的个数
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int n) {
        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        System.out.println(n);
        return true;
    }
}
