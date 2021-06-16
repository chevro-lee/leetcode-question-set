package linked;

/**
 * Author li.ling
 * Description 21. 合并两个有序链表  迭代
 *             剑指 Offer 25. 合并两个排序的链表
 * Date 2021/3/13 14:08
 */
public class Solution19 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                prev = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                prev = l2;
                l2 = l2.next;
            }
        }
        // 当l1和l2有一方移动到了最后一个节点的下一个节点，将链表连向移动到节点最后一个节点的链表
        prev.next = (l1 == null ? l2 : l1);
        return preHead.next;
    }
}
