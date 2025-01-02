package com.peng.code.dynamicProgramming;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/2 16:22
 * @Description 最长公共子序列-1143
 */

public class MaxRepeatSub {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        // 1、dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        int[][] dp = new int[len1 + 1][len2 + 1];
        int maxLen = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 找到同一个字符，
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // text1[0, i - 2]与text2[0, j - 1]的最长公共子序列 和 text1[0, i - 1]与text2[0, j - 2]的最长公共子序列，取最大的
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;
    }
}
