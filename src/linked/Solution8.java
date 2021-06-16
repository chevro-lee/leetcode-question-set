package linked;

import java.util.LinkedList;
import java.util.List;

/**
 * Author li.ling
 * Description 206. 反转链表 - 递归方法
 * Date 2021/3/10 18:10
 */
public class Solution8 {

    public ListNode reverseList(ListNode head) {
        // 递归退出条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
