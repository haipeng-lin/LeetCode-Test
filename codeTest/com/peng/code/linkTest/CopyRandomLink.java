package com.peng.code.linkTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/4 22:56
 * @Description 随机链表的复制-138
 */


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyRandomLink {

    public Node copyRandomList(Node head) {
    if (head == null) {
        return null;
    }
    // 创建一个哈希表用于存储原节点和新节点之间的映射
    Map<Node, Node> map = new HashMap<>();
    // 第一次遍历：创建所有节点并存储在哈希表中
    Node cur = head;
    while (cur != null) {
        map.put(cur, new Node(cur.val));
        cur = cur.next;
    }
    // 第二次遍历：设置新节点的 next 和 random 指针
    cur = head;
    while (cur != null) {
        map.get(cur).next = map.get(cur.next);
        map.get(cur).random = map.get(cur.random);
        cur = cur.next;
    }
    // 返回新的链表的头节点
    return map.get(head);
}
}
