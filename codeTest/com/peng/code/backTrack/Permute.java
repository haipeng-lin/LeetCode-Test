package com.peng.code.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/5 21:40
 * @Description 全排列-46
 */

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
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
            if (used[i] == true) {
                // 该元素被用了
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
