package com.ranjan.geeks.dp;

import java.util.Arrays;

public class RecursionMemoizationAndTabulation {
    public static void main(String[] args) {
        int num = 7;
        System.out.println(num + "th fibonacci number with recursion is: " + withRecursion(num));
        System.out.println(num + "th fibonacci number with memoization is: " + withMemoization(num));
        System.out.println(num + "th fibonacci number with tabulation is: " + withTabulation(num));
    }

    private static int withRecursion(int n) {
        if(n==0 || n==1) {
            return n;
        }
        return withRecursion(n-1)+withRecursion(n-2);
    }

    private static int[] memo;
    private static int withMemoization(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return memoization(n);
    }

    private static int memoization(int n) {
        int result;
        if(memo[n] == -1){
            if(n==0 || n==1){
                result=n;
            }else{
                result = memoization(n-1) + memoization(n-2);
            }
            memo[n] = result;
        }
        return memo[n];
    }

    private static int withTabulation(int n) {
        int[] tab = new int[n+1];
        tab[0] = 0;
        if(n >= 1)
            tab[1] = 1;

        for(int i = 2; i<=n;i++){
            tab[i]=tab[i-1]+tab[i-2];
        }
        return tab[n];
    }


}
