package com.peng.code.linkTest;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/6 11:43
 * @Description 排序链表-148
 */

public class SortLink {
    public ListNode sortList(ListNode head) {
        // 解法：快慢指针（找到中间节点）、断开、合并
        if (head == null || head.next == null) {
            return head;
        }
        // 1、使用快慢指针找到中间节点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断开中间节点
        ListNode mid = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        // 合并两个链表，合并完为升序链表
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
            // 注意 更新cur
            cur = cur.next;
        }
        cur.next = (l1 == null ? l2 : l1);
        return dummy.next;
    }
}
