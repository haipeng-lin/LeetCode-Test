package com.peng.code.arrayTest;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/24 19:57
 * @Description 209-长度最小的子数组
 */

public class MinSubArray {


    /**
     * 解法：滑动窗口
     * i：窗口左边；j：窗口右侧
     * 精华：控制i变化
     */
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int sum=0;  // 窗口内值和
        int minLength=Integer.MAX_VALUE;

        // 先加上该值
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            // 更新窗口长度
            while(sum>=target){
                int subLength=j-i+1;
                minLength=minLength>subLength?subLength:minLength;
                // 移动窗口左侧
                sum-=nums[i];
                i++;
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }

}
