package linked;

/**
 * Author li.ling
 * Description 141. 环形链表 - 双指针解法
 * Date 2021/3/9 17:32
 */
public class Solution1 {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (slow == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
