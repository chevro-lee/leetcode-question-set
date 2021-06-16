package linked;

/**
 * Author li.ling
 * Description 83. 删除排序链表中的重复元素
 * Date 2021/3/15 11:58
 */
public class Solution26 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
