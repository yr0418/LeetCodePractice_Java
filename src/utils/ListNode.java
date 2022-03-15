package utils;

/**
 * @moduleName: utils.ListNode
 * @description: 链表节点
 * @author: 杨睿
 * @date: 2022-02-12 20:08
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}
