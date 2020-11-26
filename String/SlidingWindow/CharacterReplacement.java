package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 * 424
 * 替换后的最长重复字符
 * @author linkuan
 * @version 1.0
 * @since 2020/11/9 20:28
 */
public class CharacterReplacement {

//    private int[] map = new int[26];
//
//    public int characterReplacement(String s, int k) {
//        if (s.length() == 0) return 0;
//        char[] chars = s.toCharArray();
//        int left = 0 , right = 0;
//        int historyCharMax = 0;
//        for (right = 0; right < chars.length; right++) {
//            int index = chars[right] - 'A';
//            map[index]++;
//            historyCharMax = Math.max(historyCharMax, map[index]);
//            while (right - left + 1 > historyCharMax + k) {
//                map[chars[left] - 'A']--;
//                left++;
//            }
//        }
//        return chars.length - left;
//    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0 , right = 0;
        int maxCount = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);

            maxCount = Math.max(maxCount, window.get(c));
            // 收缩窗口条件
            while (right - left > k + maxCount){//需要替换的字符个数就是当前窗口的大小减去窗口中数量最多的字符的数量
                char d = s.charAt(left);
                left++;

                window.put(d, window.get(d) - 1);  //缩小窗口
            }
        }

        return s.length() - left;
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;

        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);

            // 收缩窗口条件
            while (window.get(c) > 1){
                char d = s.charAt(left);
                left++;

                window.put(d, window.get(d) - 1);
            }

            res = Math.max(right - left, res);
        }

        return res;
    }

    public static void main(String[] args) {
        CharacterReplacement solution = new CharacterReplacement();
        solution.characterReplacement("AABB", 2);
    }
}
