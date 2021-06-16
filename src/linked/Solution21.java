package linked;

/**
 * Author li.ling
 * Description 2. 两数相加
 * Date 2021/3/13 14:48
 */
public class Solution21 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        // 同位相加进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum  = num1 + num2 + carry;
            // 计算进位
            carry = sum / 10;
            // 拼接相加结果链表
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
        // 计算最后一位仍然有进位
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

}
