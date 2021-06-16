package linked;

/**
 * Author li.ling
 * Description 206. 反转链表 - 迭代方法
 * Date 2021/3/11 11:39
 */
public class Solution9 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            // 交换
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
