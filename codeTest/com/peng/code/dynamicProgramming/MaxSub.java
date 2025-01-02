package com.peng.code.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/2 16:19
 * @Description 最长递增连续子序列-674
 */

public class MaxSub {
    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
