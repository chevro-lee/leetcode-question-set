package linked;

/**
 * Author li.ling
 * Description 92. 反转链表 II 迭代
 * Date 2021/3/16 16:12
 */
public class Solution29 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        // 找到开始反转的前一个节点
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        // 开始反转的当前节点
        ListNode curr = prev.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        ListNode node = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        ListNode listNode = solution29.reverseBetween(node, 2, 4);
        System.out.println(listNode);
    }
}
