package linked;

/**
 * Author li.ling
 * Description 234. 回文链表 双指针解法
 * Date 2021/3/11 22:01
 */
public class Solution13 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // 找到链表的中间节点，并找到第二段链表的头节点
        ListNode middleNode = findMiddleNode(head);
        ListNode secondHalfHead = middleNode.next;
        // 反转链表
        secondHalfHead = reverseList(secondHalfHead);
        // 判断是否为回文链表
        boolean flag = true;
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        while (flag && p2 != null) {
            if (p1.val != p2.val) {
                flag = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // 还原链表
        head.next = reverseList(secondHalfHead);
        return flag;
    }

    // 快指针走两步，慢指针走一步，当快指针走到结尾时，慢指针的位置就是中间的位置
    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 反转链表
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            // 交换
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        boolean palindrome = solution13.isPalindrome(new ListNode(1,
                new ListNode(2)));
        System.out.println(palindrome);
    }
}
