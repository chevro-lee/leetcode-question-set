package linked;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author li.ling
 * Description 817. 链表组件
 * Date 2021/3/17 17:01
 */
public class Solution33 {

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int g : G) {
            set.add(g);
        }
        ListNode curr = head;
        int result = 0;
        while (curr != null) {
            // 如果G中含有链表的当前节点，且不含链表的下一个节点，就可以认为以当前节点开始的数字是一个组件
            if (set.contains(curr.val) && (curr.next == null || !set.contains(curr.next.val))) {
                result++;
            }
            curr = curr.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0,
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3))));
        Solution33 solution33 = new Solution33();
        int[] g = new int[]{0,1,3};
        int i = solution33.numComponents(node, g);
        System.out.println(i);
    }
}
