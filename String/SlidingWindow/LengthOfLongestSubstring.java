package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 无重复字符的最长子串
 * 3
 * @author linkuan
 * @version 1.0
 * @since 2020/11/1 17:08
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int len = 0;

        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1){
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.get(d) - 1);
            }
            // 在这里更新答案
            len = Math.max(len, right - left);
        }

        return len;
    }
}
