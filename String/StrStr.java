import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 * 28
 * 实现 strstr函数
 * kmp
 * @author linkuan
 * @version 1.0
 * @since 2020/11/5 16:42
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        return 0;
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;

        int len = 0;

        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);

            // 遇到重复的字符 收缩窗口
            while (window.get(c) > 1){
                char d = s.charAt(left);
                left++;

                window.put(d, window.get(d) - 1);
            }

            len = Math.max(len, right - left);
        }

        return len;
    }

    public static void main(String[] args) {
        StrStr solution = new StrStr();
        solution.lengthOfLongestSubstring("bbbbb");
    }

}
