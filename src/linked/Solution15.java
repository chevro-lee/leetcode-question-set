package linked;

/**
 * Author li.ling
 * Description 面试题 02.02. 返回倒数第 k 个节点 - 递归解法
 * Date 2021/3/12 10:52
 */
public class Solution15 {

    int size = 0;

    public int kthToLast(ListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int val = kthToLast(head.next, k);
        if (++size == k) {
            return head.val;
        }
        return val;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        Solution15 solution15 = new Solution15();
        int i = solution15.kthToLast(listNode, 2);
        System.out.println(i);
    }
}
