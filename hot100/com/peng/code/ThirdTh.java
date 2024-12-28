package com.peng.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/28 14:15
 * @Description 15-三数之和
 */

public class ThirdTh {

    /**
     * 思路：双指针，a用一层循环，b和c用双指针
     * 注意：去重a、b、c，而且应该是找到一组后，再进行去重
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 对数组排序
        Arrays.sort(nums);
        // a、b、c 分别为 i、left、right
        int left,right;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            // 去重a
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            left=i+1;
            right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    // 找到一组
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    // 左边移动，去重b
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    // 右边移动，去重c
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return list;
    }
}
