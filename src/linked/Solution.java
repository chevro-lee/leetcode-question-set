package linked;

import java.util.HashSet;
import java.util.Set;

/**
 * Author li.ling
 * Description 141. 环形链表 - 哈希表解法
 * Date 2021/3/9 17:10
 */
public class Solution {

    private static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
               return true;
            }
            head = head.next;
        }
        return false;
    }
}
