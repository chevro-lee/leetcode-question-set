package arrays;

/**
 * Author li.ling
 * Description 345. 反转字符串中的元音字母
 * Date 2021/3/25 11:43
 */
public class Solution19 {

    public String reverseVowels(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        char temp;
        while (i < j) {
            if (!isVowel(chars[i])) {
                i++;
                continue;
            }
            if (!isVowel(chars[j])) {
                j--;
                continue;
            }
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    // 原音字母判断
    private boolean isVowel(char c) {
        switch(c) {
            case 'a' :
            case 'e' :
            case 'i' :
            case 'o' :
            case 'u' :
            case 'A' :
            case 'E' :
            case 'I' :
            case 'O' :
            case 'U' :
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "hello";
        Solution19 solution19 = new Solution19();
        String s1 = solution19.reverseVowels(s);
        System.out.println(s1);
    }
}
