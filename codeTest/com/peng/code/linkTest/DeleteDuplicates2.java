package com.peng.code.linkTest;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/3 13:47
 * @Description 删除排序链表中的重复元素||-82
 */

public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy=new ListNode(0);
    dummy.next=head;
    ListNode cur=dummy;
    while(cur.next!=null && cur.next.next!=null){
        if(cur.next.val==cur.next.next.val){
            // 发现相同元素
            int x=cur.next.val;
            while(cur.next!=null && cur.next.val==x){
                // 跳过重复元素
                cur.next=cur.next.next;
            }
        }else{
            // 安全
            cur=cur.next;
        }
    }
    return dummy.next;
}
}
