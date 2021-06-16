package linked;

/**
 * Author li.ling
 * Description 203. 移除链表元素 - 新建一个哨兵节点
 * Date 2021/3/11 15:20
 */
public class Solution10 {

    public ListNode removeElements(ListNode head, int val) {
        // 哨兵节点，便于删除第一个节点
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1,
                new ListNode(2,
                        new ListNode(6,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6)))))));
        Solution10 solution10 = new Solution10();
        solution10.removeElements(list, 6);
        System.out.println(list);
    }
}
