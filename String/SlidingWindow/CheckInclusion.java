package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 * 567
 * 字符串的排列
 * @author linkuan
 * @version 1.0
 * @since 2020/11/1 16:45
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;

        // 初始化need
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }

        while (right < s2.length()){
            // 将c移入窗口
            char c = s2.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while (right - left >= s1.length()){
                if (valid == need.size()){
                    return true;
                }
                // 移除窗口的值
                char d = s2.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return false;
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;

        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            // 维护窗口数据
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            // 窗口收缩
            while (need.size() == valid){
                if (right - left < len){
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        CheckInclusion solution = new CheckInclusion();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}
