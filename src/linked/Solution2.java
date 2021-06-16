package linked;

import java.util.HashSet;
import java.util.Set;

/**
 * Author li.ling
 * Description 142. 环形链表 II - 哈希表解法
 * Date 2021/3/9 18:21
 */
public class Solution2 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
