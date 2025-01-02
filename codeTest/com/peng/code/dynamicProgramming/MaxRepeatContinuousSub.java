package com.peng.code.dynamicProgramming;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/2 16:21
 * @Description 最长重复子数组-718
 */

public class MaxRepeatContinuousSub {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 1、dp[i][j]：以下标i-1结尾的数组A、以下标j-1结尾的数组B的最长重复子数组长度为dp[i][j]
        // 2、不用初始化，因为dp[i][0]和dp[0][j]没有意义
        int[][] dp = new int[len1 + 1][len2 + 1];
        int maxLen = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 如果nums[i-1]和nums[j-1]相等，更新dp[i][j]
                if (nums1[i - 1] == nums2[j - 1]) {
                    // dp公式：
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }

            }

        }
        return maxLen;
    }
}
