package linked;

/**
 * Author li.ling
 * Description 面试题 02.02. 返回倒数第 k 个节点 - 快慢双指针法
 * Date 2021/3/12 10:30
 */
public class Solution14 {

    public int kthToLast(ListNode head, int k) {
        if (head == null) {
            return -1;
        }
        ListNode fast = head;
        ListNode slow = head;
        int step = 1;
        while (step < k) {
            step++;
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }
}
