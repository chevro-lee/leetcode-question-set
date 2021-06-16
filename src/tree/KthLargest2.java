package tree;

import java.util.PriorityQueue;

/**
 * Author li.ling
 * Description lc 数据流中第K大元素
 * Date 2021/6/3 16:22
 */
public class KthLargest2 {


    PriorityQueue<Integer> pQueue;
    int k;

    public KthLargest2(int k, int[] nums) {
        this.k = k;
        pQueue = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pQueue.offer(val);
        // 如果当前优先队列的大小大于k，则弹出队头元素，保证队列大小为k，且队头元素为第k大的元素
        if (pQueue.size() > k) {
            pQueue.poll();
        }
        return pQueue.peek();
    }
}
