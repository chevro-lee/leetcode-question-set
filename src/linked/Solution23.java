package linked;

/**
 * Author li.ling
 * Description 876. 链表的中间结点 - 快慢指针法，快指针走两步，慢指针走一步。当快指针走到结尾时，慢指针指向的点一定是中点
 * Date 2021/3/14 16:19
 */
public class Solution23 {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
