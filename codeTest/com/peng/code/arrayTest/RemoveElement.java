package com.peng.code.arrayTest;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/24 19:30
 * @Description 27-移除元素
 */

public class RemoveElement {

    /**
     * 双指针法
     * 快指针：找出数组中值不为val的元素
     * 慢指针：更新整数组满足条件
     */
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
                count++;
            }
        }
        return count;
    }
}
