package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Author li.ling
 * Description 349. 两个数组的交集
 * Date 2021/3/30 15:14
 */
public class Solution28 {

    // 使用哈希表去重
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        int index = 0;
        int[] arr = new int[set2.size()];
        for (int i : set2) {
            if (set2.contains(i)) {
                arr[index++] = i;
            }
        }
        return arr;
    }

    // 利用双指针
    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        // 快速排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 两个指针分别指向两个数组的头部
        int i = 0;
        int j = 0;
        int index = 0;
        int[] arr = new int[nums2.length];
        // 当其中有一个指针移动到最后一位时，结束循环
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                // 保证加入的元素的唯一性
                if (index == 0 || nums1[i] != arr[index - 1]) {
                    arr[index++] = nums1[i];
                }
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(arr, 0, index);
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{4, 9, 5};
        int[] num2 = new int[]{9, 4, 9, 8, 4};
        Solution28 solution28 = new Solution28();
        int[] ints = solution28.intersection1(num1, num2);
        System.out.println(Arrays.toString(ints));
    }
}
