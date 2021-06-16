package arrays;

/**
 * Author li.ling
 * Description lc 验证回文串 - 双指针碰撞法
 * Date 2021/3/25 9:51
 */
public class Solution18 {

    public boolean isPalindrome(String s) {
        if (s == null || s.equals("") || s.equals("\" \"")) {
            return false;
        }
        s = s.replaceAll("[^A-Za-z0-9]", "");
        int i = 0;
        int j = s.length() - 1;
        while (i != j) {
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "\" \"";
        Solution18 solution18 = new Solution18();
        boolean palindrome = solution18.isPalindrome(s);
        System.out.println(palindrome);
    }
}
