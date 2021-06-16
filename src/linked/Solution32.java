package linked;

/**
 * Author li.ling
 * Description 25. K 个一组翻转链表 迭代
 * Date 2021/3/17 11:50
 */
public class Solution32 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);

        return null;
    }
}
