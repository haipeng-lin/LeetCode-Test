package com.peng.code.linkTest;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/1 17:42
 * @Description 82-删除排序链表中的重复元素||
 */

public class RemoveDuplicate2 {
    /**
     * 解法：虚拟头节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        while(cur.next!=null && cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                // 相同元素
                int x=cur.next.val;
                while(cur.next!=null && cur.next.val==x){
                    cur.next=cur.next.next;
                }
            }else{
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
