package linked;


/**
 * Author li.ling
 * Description 160. 相交链表 双指针法
 *                  算法思想：走过你走过的路，若命中注定，定会相逢；
 * Date 2021/3/10 15:02
 */
public class Solution4 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        // pa，pb每次向后移动一个位置，当有指针移动到最后一个位置，而另一个指针没有，则将该指针指向一条链表的头部节点
        // 一直循环这个操作，有相交点的两条链表，最终都会同时移动到相交点。没有相交点则会同时移动到最后一个点
        while (pa != pb) {
            pa = (pa == null ? headB : pa.next);
            pb = (pb == null ? headA : pb.next);
        }
        // 相交返回，此时可能为某个节点，也可能为链表最后一个点，即不相交的情况
        return pa;
    }
}
