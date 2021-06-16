package linked;

/**
 * Author li.ling
 * Description 剑指 Offer 18. 删除链表的节点
 * Date 2021/3/15 10:24
 */
public class Solution25 {

    public ListNode deleteNode(ListNode head, int val) {
        // 哨兵节点
        ListNode dummy = new ListNode(-1,head);
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
