package string;

/**
 * Author li.ling
 * Description lc 整数反转
 * Date 2021/3/31 17:35
 */
public class Solution1 {

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (int)res == res ? (int)res : 0;
    }

    public static void main(String[] args) {
        System.out.println(32 / 10);
    }
}
