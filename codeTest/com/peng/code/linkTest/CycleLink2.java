package com.peng.code.linkTest;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/1 17:43
 * @Description 环形链表||
 */

public class CycleLink2 {

    /**
     *  解法：使用快慢指针确定是否存在环
     *　　确定从头节点到入环节点的距离　和　快慢相遇节点到入环节点距离相等
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode tmp=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                // 存在环
                while(tmp!=fast){
                    tmp=tmp.next;
                    fast=fast.next;
                }
                return tmp;
            }
        }
        return null;
    }
}
