package linked;

/**
 * Author li.ling
 * Description 445. 两数相加 II
 * Date 2021/3/14 12:39
 */
public class Solution22 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return reverseList(head);
    }

    private ListNode reverseList(ListNode head) {
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

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        ListNode l1 = new ListNode(7,new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5,new ListNode(6, new ListNode(4)));
        ListNode node = solution22.addTwoNumbers(l1, l2);
        System.out.println(node);
    }
}
