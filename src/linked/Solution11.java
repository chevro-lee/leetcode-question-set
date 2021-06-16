package linked;

/**
 * Author li.ling
 * Description 203. 移除链表元素 - 通常解法
 * Date 2021/3/11 17:23
 */
public class Solution11 {

    public ListNode removeElements(ListNode head, int val) {
        // 判断头节点是否有相同的值
        while (head != null && head.val == val) {
            // 使用循环避免下一个头节点的下一个节点依然是相等的值
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
