package linked;

/**
 * Author li.ling
 * Description 143. 重排链表
 * Date 2021/3/14 16:37
 */
public class Solution24 {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 找到链表的中间节点
        ListNode mid = middleNode(head);
        ListNode head2 = mid.next;
        mid.next = null;
        // 将中间节点开始的第二段链表反转
        head2 = reverseList(head2);
        // 重连接两个链表
        ListNode head1 = head;
        mergeList(head1, head2);
    }

    private void mergeList(ListNode head1, ListNode head2) {
        ListNode next1 = null;
        ListNode next2 = null;
        while (head1 != null && head2 != null) {
            next1 = head1.next;
            next2 = head2.next;
            head1.next = head2;
            head1 = next1;
            head2.next = head1;
            head2 = next2;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        ListNode listNode = new ListNode(1);
        solution24.reorderList(listNode);
    }
}
