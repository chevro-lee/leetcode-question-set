package linked;

/**
 * Author li.ling
 * Description 24. 两两交换链表中的节点 递归
 * Date 2021/3/17 10:29
 */
public class Solution31 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
