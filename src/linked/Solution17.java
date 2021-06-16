package linked;

/**
 * Author li.ling
 * Description 61. 旋转链表 - 搬运节点法
 * Date 2021/3/12 15:20
 */
public class Solution17 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 求出链表长度
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        // 通过前指针找到节点需要插入到哪个节点的后面
        int step = 1;
        ListNode front = head;
        int n = k % length;
        if (n == 0) {
            return head;
        }
        while (step < length - n) {
            step++;
            front = front.next;
        }
        // 移动节点
        ListNode newHead = front.next;
        tail.next = head;
        front.next = null;
        // 移动头节点位置
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0,new ListNode(1, new ListNode(3)));
        Solution17 solution17 = new Solution17();
        ListNode node = solution17.rotateRight(listNode, 2);
        System.out.println(node);
        System.out.println(2%5);
    }
}
