package com.peng.code.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/2 16:20
 * @Description 最长递增子序列-300
 */

public class MaxContinuousSub {
    public int lengthOfLIS(int[] nums) {
        int maxLen = 1;
        // 1、dp[i]：以nums[i]为结尾的最长递增子序列长度
        int[] dp = new int[nums.length];
        // 2、初始化：每个元素的最长递增子序列长度均为1
        Arrays.fill(dp, 1);
        // 4、从前往后遍历
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 遍历 [0,i-1]公式
                // 3、dp公式：dp[i]=Math(dp[i],dp[j]+1);
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
