package com.peng.code.linkTest;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/3 13:42
 * @Description 合并K个有序链表-23
 */

public class MergeKList {

    public ListNode mergeKLists1(ListNode[] lists) {
        // 解法：顺序合并
        ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeTwoList1(ans, list);
        }
        return ans;
    }

    public static ListNode mergeTwoList1(ListNode l1, ListNode l2) {
        // 虚拟头节点合并两链表
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}
