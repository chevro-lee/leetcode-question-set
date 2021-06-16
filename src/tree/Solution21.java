package tree;


import java.util.TreeSet;

/**
 * Author li.ling
 * Description 220. 存在重复元素Ⅲ
 * Date 2021/6/5 14:36
 */
public class Solution21 {

    /**
     * 滑动窗口 + 二叉搜索树
     * 根据条件 |nums[i] - nums[j]| <= t 可得 nums[i] - t <= num[j],num[i] + t >= num[j]
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 取到树中大于num[i] - t的最小值
            Integer numJ = set.ceiling(nums[i] - t);
            // 如果滑动窗口中的数存在满足num[i] - numJ（滑动窗口中的数）<= t
            if (numJ != null && numJ <= nums[i] + t) {
                return true;
            }
            set.add(nums[i]);
            // 维护滑动窗口的大小
            if (set.size() > k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
