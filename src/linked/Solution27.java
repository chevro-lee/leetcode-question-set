package linked;

/**
 * Author li.ling
 * Description 面试题 02.06. 回文链表 递归法
 *             通过递归，将head指针指向最后一个节点,current节点从左边开始，head节点从右边开始比较
 *              同 234. 回文链表
 * Date 2021/3/16 9:56
 */
public class Solution27 {

    ListNode current;

    public boolean isPalindrome(ListNode head) {
        current = head;
        return check(head);
    }

    private boolean check (ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = check(head.next) && (current.val == head.val);
        current = current.next;
        return res;
    }
}
