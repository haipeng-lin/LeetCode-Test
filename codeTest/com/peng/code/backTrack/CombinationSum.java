package com.peng.code.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/5 21:41
 * @Description 组合总和-39
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        back(ans, path, candidates, 0, 0, target);
        return ans;
    }

    public void back(List<List<Integer>> ans, List<Integer> path, int[] nums, int startIndex, int sum, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            sum += nums[i];
            path.add(nums[i]);
            // 注意：同一个数字可以无限制重复被选取，所以下一个从i开始
            back(ans, path, nums, i, sum, target);
            // 回溯
            path.remove(path.size() - 1);
            sum -= nums[i];
        }
    }
}
