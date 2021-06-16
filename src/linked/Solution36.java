package linked;

/**
 * Author li.ling
 * Description 1669. 合并两个链表 - 双指针
 * Date 2021/3/20 18:08
 */
public class Solution36 {


    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list1 == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, list1);
        ListNode curr = dummy;
        // 通过双指针找到需要被切割的链条的位置
        b = b - a + 1;
        while (a > 0) {
            a--;
            curr = curr.next;
        }
        ListNode back = curr;
        while (b > 0) {
            curr = curr.next;
            b--;
        }
        ListNode front = curr;
        // 拼接
        back.next = list2;
        // 找到第二条链表末尾的位置
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = front.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution36 solution36 = new Solution36();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode listNode1 = new ListNode(4, new ListNode(5, new ListNode(6)));
        ListNode listNode2 = solution36.mergeInBetween(listNode, 1, 1, listNode1);
        System.out.println(listNode2);
    }
}
