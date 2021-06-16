package arrays;

/**
 * Author li.ling
 * Description 832. 翻转图像
 * Date 2021/3/6 19:25
 */
public class Solution7 {

    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int start = 0;
            int end = image.length - 1;
            while (start < end) {
                if (image[i][start] == image[i][end]) {
                    image[i][start] ^= 1;
                    image[i][end] ^= 1;
                }
                start++;
                end--;
            }
            if (start == end) {
                image[i][start] ^= 1;
            }
        }
        return image;
    }
}
