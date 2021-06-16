package linked;

import java.util.HashSet;
import java.util.Set;

/**
 * Author li.ling
 * Description 160. 相交链表 哈希表法
 * Date 2021/3/10 16:02
 */
public class Solution5 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        Set<ListNode> set = new HashSet<>();
        while (pa != null) {
            set.add(pa);
            pa = pa.next;
        }
        while (pb != null) {
            if (set.contains(pb)) {
                return pb;
            }
            pb = pb.next;
        }
        return null;
    }
}
