package string;

/**
 * Author li.ling
 * Description lc 反转字符串
 * Date 2021/3/31 15:52
 */
public class Solution {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        char temp;
        int m = 0;
        int n = s.length - 1;
        while (m < n) {
            temp = s[m];
            s[m] = s[n];
            s[n] = temp;
            m++;
            n--;
        }
    }
}
