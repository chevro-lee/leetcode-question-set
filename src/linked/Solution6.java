package linked;

/**
 * Author li.ling
 * Description 19. 删除链表的倒数第 N 个结点 - 计算链表长度
 * Date 2021/3/10 16:21
 */
public class Solution6 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        // 虚拟节点，避免边界问题，便于删除第一个节点
        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy;
        for (int i = 1; i < length - n + 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
