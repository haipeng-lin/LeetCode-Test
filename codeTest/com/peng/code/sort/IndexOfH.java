package com.peng.code.sort;

import java.util.Arrays;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/2 16:25
 * @Description H指数-274
 */

public class IndexOfH {


    public int hIndex1(int[] citations) {
        // 解法：排序
        Arrays.sort(citations);
        int len = citations.length;
        int h = 0;
        // 从后往前遍历
        for (int i = len - 1; i >= 0; i--) {
            // 条件2：引用次数大于h
            // 问题：当引用次数正好等于 h 时，我们希望它不计入
            // 因为 h 指数 的定义要求的是至少有 h 篇论文被引用 大于或等于 h 次，而 引用次数等于 h 并不能满足这种"至少"的条件
            if (citations[i] > h) {
                h++;
            }
        }
        return h;
    }

    public int hIndex2(int[] citations) {
        // 解法：计数排序
        int len = citations.length;
        int[] counter = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len) {
                // 引用次数超过或等于n，按文章数统计
                counter[len]++;
            } else {
                // 对应的引用次数加一
                counter[citations[i]]++;
            }
        }
        int sum = 0;
        // 从后往前遍历counter，找到大于或等于当前引用次数i的总论文数
        for (int i = len; i >= 0; i--) {
            sum += counter[i];
            if (sum >= i) {
                // 总论文数至少大于等于引用次数，此时引用次数即为最大h
                return i;
            }
        }
        return 0;
    }

    public int hIndex3(int[] citations) {
        // 解法：二分查找，抽象为 n个数中，至少有h个数大于等于h
        // 直接按中间数查找，h肯定不会超过文章数
        int left = 0;
        int right = citations.length;
        int middle = 0;   // 中间数
        int hMax = 0;     // 最大的h
        while (left <= right) {
            middle = left + (right - left) / 2;   // 得到中间数
            // 统计满足条件的数量
            int middlesum = 0;
            for (int citation : citations) {
                if (citation >= middle) {
                    // 该数大于选定的中间数middle
                    middlesum++;
                }
            }
            // 判断向上or向下
            if (middlesum >= middle) {
                // 向上即右，更新最大h
                left = middle + 1;
                hMax = Math.max(hMax, middle);
            } else {
                right = middle - 1;
            }
        }
        return hMax;
    }
}
