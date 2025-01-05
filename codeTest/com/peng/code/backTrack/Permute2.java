package com.peng.code.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/5 21:40
 * @Description 全排列2-47
 */

public class Permute2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        back(ans, path, nums, used);
        return ans;
    }

    public void back(List<List<Integer>> ans, List<Integer> path, int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 同一层不能重复使用同一元素
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
                continue;
            }

            if (used[i] == true) {
                // 同一树枝该元素被用了
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            back(ans, path, nums, used);
            // 回溯
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
