package linked;

/**
 * Author li.ling
 * Description 328. 奇偶链表 双指针分离链表法
 * Date 2021/3/11 17:34
 */
public class Solution12 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 奇数指针
        ListNode odd = head;
        // 偶数头指针
        ListNode evenHead = head.next;
        // 偶数指针
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            // 删除两个奇数节点中间的偶数节点
            odd.next = even.next;
            // 删除之后往后移动奇数指针，移动之后仍是奇数点
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        // 将偶数头指针重定向指向奇数节点的最后一个节点
        odd.next = evenHead;
        return head;
    }
}
