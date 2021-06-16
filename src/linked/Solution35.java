package linked;

/**
 * Author li.ling
 * Description
 * Date 2021/3/18 23:12
 */
public class Solution35 {

    public int getDecimalValue(ListNode head) {
        int res = 0;
        ListNode curr = head;
        while (curr != null) {
            res = res * 2 + curr.val;
            curr = curr.next;
        }
        return res;
    }
}
