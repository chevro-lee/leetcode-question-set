package linked;

/**
 * Author li.ling
 * Description 82.删除排序链表中的重复元素Ⅱ
 * Date 2021/3/16 11:09
 */
public class Solution28 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1, head);
        ListNode front = head;
        ListNode back = pre;
        while (front != null && front.next != null) {
            // 判断前后节点指向的值是否相等
            if (back.next.val != front.next.val) {
                // 不相等，则两个指针皆向前移动一步
                back = back.next;
                front = front.next;
            } else {
                // 相等，移动前指针直到不相等
                while (front.next != null && back.next.val == front.next.val) {
                    front = front.next;
                }
                // 找到了相等之后不相等的节点，开始删除相同节点
                back.next = front.next;
                // 删除之后移动前指针
                front = front.next;
            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        Solution28 solution28 = new Solution28();
        ListNode deleteDuplicates = solution28.deleteDuplicates(node);
        System.out.println(deleteDuplicates);
    }
}
