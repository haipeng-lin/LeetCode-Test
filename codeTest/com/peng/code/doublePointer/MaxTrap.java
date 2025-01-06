package com.peng.code.doublePointer;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/6 11:42
 * @Description 接雨水-42
 */

public class MaxTrap {
    public int trap(int[] height) {
        // 解法：双指针
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while (left <= right) {
            // 1、更新最高的left和max
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                // 左边低，计算左边
                ans += (leftMax - height[left]);
                left++;
            } else {
                // 右边低，计算右边
                ans += (rightMax - height[right]);
                right--;
            }
        }
        return ans;
    }
}
