package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * 438
 * 找到字符串中所有字母异位词
 * @author linkuan
 * @version 1.0
 * @since 2020/11/1 17:29
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>(),window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }

        int left = 0,right = 0;
        int valid = 0;

        List<Integer> res = new ArrayList<>();

        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while (right - left >= p.length()){
                if (valid == need.size()){
                    res.add(left);
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
        return res;
    }

    public static void main(String[] args) {
        FindAnagrams solution = new FindAnagrams();
        solution.findAnagrams("cbaebabacd",
                "abc");

        solution.checkInclusion("oo","eidbaooo");
        solution.findAnagrams11("cbaebabacd","abc");
        solution.characterReplacement("AABABBA",1);
    }

    public List<Integer> findAnagrams11(String s, String p) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        List<Integer> res = new ArrayList<>();

        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            // 收缩窗口
            while (right - left >= p.length()){
                if (need.size() == valid){
                    res.add(left);
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

        return res;
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()){
            char c = s2.charAt(right);
            right++;

            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while (right - left >= s1.length()){
                if (valid == need.size()){
                    return true;
                }

                char d = s2.charAt(left);
                left++;

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

    public int characterReplacement(String s, int k) {
        int[] window = new int[26];
        int left = 0, right = 0;
        int maxCount = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            window[c - 'A']++;

            maxCount = Math.max(maxCount, window[c - 'A']);

            while (right - left > maxCount + k){
                char d = s.charAt(left);
                left++;

                window[d - 'A']--;
            }
        }

        return s.length() - left;
    }

}
