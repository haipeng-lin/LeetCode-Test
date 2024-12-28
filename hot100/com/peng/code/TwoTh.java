package com.peng.code;


/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/28 13:49
 * @Description 25-K个一组翻转链表
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

public class TwoTh {

    public ListNode reverseKGroup(ListNode head, int k) {
        // 思想：k个k个为一组反
        ListNode tail=head;
        // 找到尾节点，再进行翻转，左闭右开
        for(int i=0;i<k;i++){
            if(tail==null){
                // 不足k个，返回头节点
                return head;
            }
            tail=tail.next;
        }
        ListNode realHead=reverse(head,tail);
        // 递归遍历，并将这一组的尾节点连接下一组的头节点
        // 已经翻转完，所以head为尾节点
        head.next=reverseKGroup(tail,k);
        return realHead;
    }
    public static ListNode reverse(ListNode head,ListNode tail){
        // 对 [head，tail）进行反转
        ListNode cur=head;
        ListNode pre=null;
        while(cur!=tail){
            ListNode tmp=cur.next;
            cur.next=pre;   // 翻转
            pre=cur;
            cur=tmp;
        }
        return pre; // 返回翻转完的头节点
    }
}
