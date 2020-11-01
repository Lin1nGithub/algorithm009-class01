/**
 * https://leetcode-cn.com/problems/reverse-string/
 * 344
 * 反转字符串
 * @author linkuan
 * @version 1.0
 * @since 2020/10/9 18:04
 */
public class ReverseString {

    public void reverseString(char[] s) {

        if (null == s || s.length == 0) return;

        int left = 0;
        int right = s.length - 1;

        while (left < right){

            char temp = s[right];

            s[right] = s[left];

            s[left] = temp;

            left++;right--;
        }
    }
}
