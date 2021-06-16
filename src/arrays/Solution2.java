package arrays;

/**
 * Author li.ling
 * Description 1588. 所有奇数长度子数组的和 - 思路：求出数组的每个数在子数组出现的次数 * 这个数的值 = 所有子数组的和
 * Date 2021/3/4 10:07
 */
public class Solution2 {

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // i为数组的下标，取i左右两边的数，保证凑得的数组为连续的以及为奇数个的数组
            // 以下标i = 1为例，数组为[1,4,2,5,3]，i左边可取0个，也就是取本身{4}，i左边还可取1个{1,4}，也就是取两次;
            // i右边可取0个{4}，1个{4，2}，2个{4，2，5}，3个{4，2，5，3}，也就是取4次，由此可得以下公式
            int left = i + 1;   // 左边可取的次数
            int right = arr.length - (i + 1) + 1;  //右边可取的次数
            // 只有当左边取奇数个右边取奇数个，以及左边取偶数个右边取偶数个的时候，才能保证拼凑的数组为奇数个的数组
            // 左右取奇的个数如下
            int leftOdd = left / 2;
            int rightOdd = right / 2;
            // 左右取偶的个数如下
            int leftEven = (left + 1) / 2;
            int rightEven = (right + 1) / 2;
            // 出现的总次数 * 当前值
            sum += (leftOdd*rightOdd + leftEven*rightEven) * arr[i];
        }
        return sum;
    }

}
