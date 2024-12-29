package com.peng.code;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/29 9:55
 * @Description 53-最大子数组和
 */

public class FourTh {

    /**
     * 解法：动归
     * dp[i]：表示以nums[i]结尾的最大子数组和
     * 遍历公式：dp[i]=Math.max(dp[i-1]+nums[i],nums[i])，要不要加上前面的dp[i]
     * 初始化：dp[0]=nums[0]，加上此数
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        int result=nums[0];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            result=Math.max(result,dp[i]);
        }
        return result;
    }
}
