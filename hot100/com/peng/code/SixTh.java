package com.peng.code;

import java.util.Random;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/29 11:09
 * @Description 912-快速排序
 */

public class SixTh {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public static void quickSort(int[] nums,int left,int right){
        if(left<right){
            int partition=partition(nums,left,right);
            quickSort(nums,left,partition-1);
            quickSort(nums,partition+1,right);
        }
    }

    /**
     * 选定最右边元素为基准值，排序完比基准值小的在左边，大的在右边
     * 返回基准值下标
     */
    public static int partition(int[] nums,int left,int right){
        // 优化：随机选定基准值
        int randomIndex = left + new Random().nextInt(right - left + 1);

        // 将随机基准值与最右边的元素交换，这样基准值就位于最右边
        swap(nums, randomIndex, right);

        int pivot=nums[right];
        int slow=left;
        for(int i=left;i<right;i++){
            if(nums[i]<pivot){
                swap(nums,slow,i);
                slow++;
            }
        }
        swap(nums,slow,right);
        return slow;
    }

    public static void swap(int[] nums,int left,int right){
        int tmp=nums[left];
        nums[left]=nums[right];
        nums[right]=tmp;
    }
}
