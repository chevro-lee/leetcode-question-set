package linked;

/**
 * Author li.ling
 * Description 剑指 Offer 22. 链表中倒数第k个节点 - 双指针解法
 * Date 2021/3/12 14:28
 */
public class Solution16 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int step = 1;
        while (step < k) {
            step++;
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
