package arrays;

import java.util.*;

/**
 * Author li.ling
 * Description lc 两个数组的交集 II
 * Date 2021/3/30 9:41
 */
public class Solution27 {

    // 使用哈希表存储两个数组，判断小的哈希表中的每个数是否存在另一个哈希表中
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            if (map.get(i) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] num1 = new int[] {1,2,2,1};
        int[] num2 = new int[] {2};
        Solution27 solution27 = new Solution27();
        int[] intersect = solution27.intersect(num1, num2);
        System.out.println(Arrays.toString(intersect));
    }


}
