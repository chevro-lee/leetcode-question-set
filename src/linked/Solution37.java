package linked;

import java.util.Arrays;

/**
 * Author li.ling
 * Description 725. 分隔链表
 * Date 2021/3/20 23:27
 */
public class Solution37 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] nodeArray = new ListNode[k];
        if (root == null || k == 0) {
            return nodeArray;
        }
        // 计算结点数
        ListNode curr = root;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        // 切割成k个部分，每个部分的结点数
        int num = count / k;
        // 切割成k个部分，可能会产生多余的节点数
        int rem = count % k;
        // 重置curr 指向头节点
        curr = root;
        for (int i = 0; i < k; i++) {
            // 每个片段的链表头
            ListNode newHead = curr;
            // 移动curr节点，找到每个部分切割的点
            for (int j = 0; j < num + (i < rem ? 1 : 0) - 1; j++) {
                if (curr != null) {
                    curr = curr.next;
                }
            }
            if (curr != null) {
                ListNode prev = curr;
                // curr指向下一个片段头结点
                curr = curr.next;
                // 切断当前片断链表与下一个片段链表的联系
                prev.next = null;
            }
            // 存入数据
            nodeArray[i] = newHead;
        }
        return nodeArray;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        int k = 5;
        Solution37 solution37 = new Solution37();
        ListNode[] listNodes = solution37.splitListToParts(listNode, k);
        System.out.println(Arrays.toString(listNodes));
    }
}
