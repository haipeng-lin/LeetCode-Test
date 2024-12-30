package com.peng.code;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/30 16:00
 * @Description 合并两个有序链表-21
 */

public class SevenTh {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        // 循环比较两个链表的节点，并将较小的节点连接到新链表中
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        // 将剩余的节点连接到新链表的末尾
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        // 返回合并后的链表
        return dummy.next;

    }
}
