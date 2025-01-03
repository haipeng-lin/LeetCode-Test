package com.peng.code.linkTest;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/3 13:47
 * @Description 删除排序链表中的重复元素-83
 */

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
    ListNode cur=head;
    ListNode pre=null;
    while(cur!=null && cur.next!=null){
        if(cur.val==cur.next.val){
            // 当前元素和下一个元素相同，跳过下一个元素
            cur.next=cur.next.next;
        }else{
            // 不相同，移动当前cur
            cur=cur.next;
        }
    }
    return head;
}
}
