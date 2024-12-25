package com.peng.code.linkTest;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/25 13:37
 * @Description 206-反转链表
 */


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class ReverseLink {

    /**
     * 解法：双指针
     */
    public ListNode reverseList(ListNode head) {
        //
        ListNode pre = null; // 前一个节点
        ListNode cur = head; // 当前节点
        ListNode tmp;       // 临时节点
        while (cur != null) {
            tmp = cur.next;   // 暂存下一个节点
            cur.next = pre;   // 反转
            pre = cur;
            cur = tmp;
        }
        return pre;

    }
}
