package com.peng.code.linkTest;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/3 13:46
 * @Description 相交链表-160
 */

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        // 统计两链表长度
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        // 回归头节点
        curA = headA;
        curB = headB;
        // 确保 lenA、curA指向的是较长的链表
        if (lenB > lenA) {
            int tmp = lenB;
            lenB = lenA;
            lenA = tmp;

            ListNode curTmp = curB;
            curB = curA;
            curA = curTmp;
        }

        // 计算需要移动的距离，确保双指针可以同时到达终点
        int gap = lenA - lenB;
        for (int i = 0; i < gap; i++) {
            curA = curA.next;
        }

        //curA curB同时移动
        while (curA != null && curB != null) {
            // 注意：是指针相同
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
