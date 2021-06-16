package linked;

/**
 * Author li.ling
 * Description 删除链表的倒数第 N 个结点 - 双指针法
 * Date 2021/3/10 17:34
 */
public class Solution7 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟节点，方便删除第一个节点
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && n-- > 0) {
            fast = fast.next;
        }
        // 快指针没有走到n步，就没有下一个节点了
        if (n > 0) {
            return null;
        }
        // 快制证走到末尾与满指针相差n个
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
