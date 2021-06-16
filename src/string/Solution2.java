package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author li.ling
 * Description lc 字符串中的第一个唯一字符
 * Date 2021/3/31 17:49
 */
public class Solution2 {

    public int firstUniqChar(String s) {
        if (s == null || ("").equals(s)) {
            return -1;
        }
        char[] str = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c : str) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < str.length; i++) {
            if (map.get(str[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
