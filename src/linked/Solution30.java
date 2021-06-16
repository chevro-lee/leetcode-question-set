package linked;

/**
 * Author li.ling
 * Description 24. 两两交换链表中的节点 - 迭代
 * Date 2021/3/17 9:21
 */
public class Solution30 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode p1 = temp.next;
            ListNode p2 = temp.next.next;
            // 交换
            temp.next = p2;
            p1.next = p2.next;
            p2.next = p1;
            // 移动temp的位置下次循环交换几点
            temp = p1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));
        Solution30 solution30 = new Solution30();
        ListNode swapPairs = solution30.swapPairs(listNode);
        System.out.println(swapPairs);
    }
}
