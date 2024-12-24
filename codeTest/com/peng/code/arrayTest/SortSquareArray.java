package com.peng.code.arrayTest;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/24 19:36
 * @Description 977-有序数组的平方
 */

public class SortSquareArray {

    /**
     *  解法：双指针
     */
    public int[] sortedSquares(int[] nums) {
        // 原本有序，平方后的数不是左边负数的最大，就是右边正数的最大
        int left=0;
        int right=nums.length-1;
        int index=nums.length-1;
        int[] returnNums=new int[nums.length];
        while(left<=right){
            if(nums[left]*nums[left]>nums[right]*nums[right]){
                // 左边大
                returnNums[index--]=nums[left]*nums[left];
                left++;
            }else{
                // 右边大
                returnNums[index--]=nums[right]*nums[right];
                right--;
            }
        }
        return returnNums;
    }
}
