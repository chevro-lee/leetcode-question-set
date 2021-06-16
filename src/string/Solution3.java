package string;

import java.util.Arrays;

/**
 * Author li.ling
 * Description lc 有效的字母异位词
 * Date 2021/3/31 18:25
 */
public class Solution3 {

    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars,chart);
    }
}
