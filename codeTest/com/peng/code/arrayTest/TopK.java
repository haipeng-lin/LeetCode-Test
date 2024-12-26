package com.peng.code.arrayTest;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/25 22:43
 * @Description LCR076数组中的第K大元素
 */

public class TopK {


    /**
     *  解法：快速排序：每次排序找到一个基准值，并满足左边的元素比该值大，右边的元素比该值小
     *  比如：1、3、4、2：找第3大数字：2
     *  第一次找的基准值为2，排序结果：3，4，2，1
     *  此时2下标为2，2+1=k:即第3大
     */
    public int findKthLargest(int[] nums, int k) {

        return quickSort(nums,0,nums.length-1,k);
    }

    // 根据快速排序，找到第K大元素
    public static int quickSort(int[] nums, int left, int right, int k){
        int partition=partition(nums,left,right);
        while(partition+1!=k){
            if(partition+1<k){
                // 右边找
                left=partition+1;
            }else if(partition+1>k){
                // 左边找
                right=partition-1;
            }
            partition=partition(nums,left,right);
        }
        return nums[partition];
    }

    // 以最右边为基准，并倒序排序，
    public static int partition(int[] nums, int left, int right){
        int pivot=nums[right];
        int slow=left;
        for(int fast=left;fast<right;fast++){
            if(nums[fast]>pivot){
                // 交换快慢指针的元素
                swap(nums,slow,fast);
                slow++;
            }
        }
        swap(nums,slow,right);
        return slow;
    }

    // 交换左右下标的元素
    public static void swap(int[] nums, int left, int right){
        int tmp=nums[left];
        nums[left]=nums[right];
        nums[right]=tmp;
    }
}
