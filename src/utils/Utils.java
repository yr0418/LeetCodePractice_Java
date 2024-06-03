package utils;

/**
 * @moduleName: Utils
 * @description:
 * @author: 杨睿
 * @date: 2024/5/23 下午12:40
 */
public class Utils {
    /**
     * 构建链表
     *
     * @param arr 链表数据
     * @return ListNode
     */
    public static ListNode buildLinkList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            cur.next = temp;
            cur = temp;
        }
        return head;
    }
}
