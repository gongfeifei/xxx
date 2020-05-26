package com.gff.solution;

public class LIS {
    public static int[] getdp2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m]) { //找ends中最左边大于等于arr[i]的
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l); //ends数组最后一个元素的下标
            ends[l] = arr[i];   //ends数组是 以arr[i]结尾的最长递增子序列      ends[0...right]为有效区   ends[b]==c表示遍历到目前为止，在所有长度为b+1的递增序列中，最小的结尾数为c
            dp[i] = 1 + l;  //dp[i]是 以arr[i]结尾的最长递增子序列的长度
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] dp = getdp2(new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7});

    }
}
