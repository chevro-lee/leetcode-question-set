package string;

/**
 * Author li.ling
 * Description lc 实现strStr() - 双指针
 * Date 2021/4/1 15:16
 */
public class Solution4 {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        // 初始化两个指针，分别指向haystack和needle的第一个元素
        int i = 0;
        int j = 0;
        // index用于标明与needle的j指向元素相等的i位置下标
        int index = -1;
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        int lenHay = haystacks.length;
        int lenNee = needles.length;
        while (i < lenHay) {
            if (haystacks[i] == needles[j]) {
                // 记录开始相等的位置
                if (index == -1) {
                    index = i;
                }
                if (j == lenNee - 1) {
                    return i - lenNee + 1;
                }
                j++;
            } else {
                // 如果存在部分相等的情况，将i的值设为index的下一位，并重置j
                if (index != -1) {
                    i = index;
                    index = -1;
                    j = 0;
                }
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int i = solution4.strStr("mississippi", "issip");
        String fileName = "1231.pdf";
//        fileName = fileName.substring(0, fileName.indexOf("."));
        String fileSuffix = fileName.substring(fileName.indexOf(".")+1);
        System.out.println(fileSuffix);
        System.out.println(i);
    }
}
