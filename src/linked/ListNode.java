package linked;

import java.util.List;

/**
 * Author li.ling
 * Description
 * Date 2021/3/9 17:33
 */
public class ListNode {

    int val;
    ListNode next;

    public ListNode(int value) {
        this.val = value;
    }

    public ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + val +
                ", next=" + next +
                '}';
    }
}
