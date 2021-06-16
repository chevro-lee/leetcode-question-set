package arrays;

/**
 * Author li.ling
 * Description
 * Date 2021/3/24 18:04
 */
public class Solution17 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}
