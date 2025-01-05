package com.peng.code.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/5 21:41
 * @Description 组合总和-40
 */

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] isUsed = new boolean[candidates.length];
        Arrays.fill(isUsed, false);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        back(ans, path, candidates, 0, 0, target, isUsed);
        return ans;
    }

    public void back(List<List<Integer>> ans, List<Integer> path, int[] nums, int startIndex, int sum, int target, boolean[] isUsed) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            // 排除同一层 该数字已经使用过了
            if (i > 0 && nums[i - 1] == nums[i] && isUsed[i - 1] == false) {
                continue;
            }
            sum += nums[i];
            path.add(nums[i]);
            isUsed[i] = true;
            back(ans, path, nums, i + 1, sum, target, isUsed);
            // 回溯
            isUsed[i] = false;
            path.remove(path.size() - 1);
            sum -= nums[i];
        }
    }
}
