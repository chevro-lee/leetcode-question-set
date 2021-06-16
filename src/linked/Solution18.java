package linked;

/**
 * Author li.ling
 * Description 61. 旋转链表 - 循环链表法
 * Date 2021/3/13 10:29
 */
public class Solution18 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        // 首位相连形成循环链表
        tail.next = head;
        // 找到切开点，将循环链表变成单向链表
        int step = 1;
        ListNode front = head;
        int n = k % length;
        while (step < length - n) {
            front = front.next;
            step++;
        }
        ListNode newHead = front.next;
        front.next = null;
        return newHead;
    }
}
