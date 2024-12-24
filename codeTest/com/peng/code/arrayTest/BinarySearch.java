package com.peng.code.arrayTest;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/24 19:06
 * @Description 704-二分查找
 */

public class BinarySearch {

    /**
     * 左闭右闭
     */
    public static int search1(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        // 1、因为左闭右闭，所以left和right相等有意义
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                // 2、right有意义，故需往左一位
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * 左闭右开
     */
    public static int search2(int[] nums, int target) {
        int left=0;
        int right=nums.length;
        // 1、因为左闭右开，所以left和right相等没有意义
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                // 2、right没有意义
                right=mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{-1,0,3,5,9,12};
        System.out.println("下标："+search2(nums,9));
    }
}
