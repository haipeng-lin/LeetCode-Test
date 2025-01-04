package com.peng.code.linkTest;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/4 22:42
 * @Description 奇偶链表-328
 */

public class OddEvenLink {

    public ListNode oddEvenList(ListNode head) {
    // 解法：先分离奇偶节点、再合并
    if(head==null){
        return head;
    }
    ListNode odd=head;   // 奇节点
    ListNode even=head.next;  // 偶节点
    ListNode evenHead=even;  // 偶节点头
    while(even!=null && even.next!=null){
        odd.next=even.next; // 奇节点连接偶节点的后面
        odd=odd.next;
        even.next=odd.next; // 偶节点连接奇节点的后面
        even=even.next;
    }
    // 奇节点连接偶节点头
    odd.next=evenHead;
    return head;
}
}
