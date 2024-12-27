package com.peng.code.linkTest;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/26 22:36
 * @Description 24-两两交换链表中的节点
 */

public class SwapPairs {


    /**
     *  head——>1——>2——>3——>4——>5——>6
     *  步骤一（虚拟节点连接第二个节点）：head——>2.....
     *  步骤二（第一个节点连接第二个节点的后面）：
     *  步骤三（第二个节点连接第一个节点）
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead=new ListNode(0,head);
        ListNode cur=dummyHead;
        while(cur.next!=null && cur.next.next!=null) {
            ListNode node1=cur.next;    // 第一个节点
            ListNode node2=cur.next.next;   // 第二个节点
            cur.next=node2;             // 步骤一：虚拟节点连接第二个节点
            node1.next=node2.next;      // 步骤二：第一个节点连接第二个节点的后面
            node2.next=node1;           // 步骤三：第二个节点连接第一个节点
            // 更新虚拟节点
            cur=cur.next.next;
        }
        return dummyHead.next;
    }
}
