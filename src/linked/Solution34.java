package linked;

/**
 * Author li.ling
 * Description 面试题 02.08. 环路检测
 * Date 2021/3/17 18:27
 */
public class Solution34 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 构建第一次相遇
        while (true) {
            if (fast == null || fast.next == null) {
                // 快指针走到最后节点，说明没有环
                return null;
            }
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        // 通过数学公式推导，相遇之后，将快指针指向头部，下次相遇即为环形链表入口点
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
