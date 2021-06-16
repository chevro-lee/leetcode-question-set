package arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Author li.ling
 * Description 219.存在重复元素Ⅱ
 * Date 2021/6/5 10:39
 */
public class Solution34 {

    /**
     * 滑动窗口 维持一个k大小的滑动窗口
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(i - k, 0); j < i; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 使用二叉搜索树，维护一个大小为k的一个二叉搜索树，如果插入之后超过了k，则移除
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            // 没有超过k个元素的情况出现，就删除此时k个位置之前的值
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    /**
     * 采用哈希表的数据结构存储，维护大小为k的哈希表
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
