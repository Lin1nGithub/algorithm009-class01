package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/10/31 17:40
 */
public class SlidingWindow {

    /**
     * int left = 0, right = 0;
     *
     * while (right < s.size()) {
     *     // 增大窗口
     *     window.add(s[right]);
     *     right++;
     *
     *     while (window needs shrink) {
     *         // 缩小窗口
     *         window.remove(s[left]);
     *         left++;
     *     }
     * }
     * @param S
     * @param T
     */
    private void slidingWindow(String S, String T){
        Map<Character, Integer> need, window;
        // need T中字符出现次数
        // window 「窗口」中的相应字符的出现次数

        int left = 0, right = 0;
        while (right < S.length()){
            char c = S.charAt(right);
            right++;


        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return quickSort(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSort(int[] nums, int lo, int hi, int k){
        int j = partition(nums, lo, hi);
        if (j == k){
            return Arrays.copyOf(nums, k + 1);
        }
        return j > k ? quickSort(nums, lo, j - 1, k) : quickSort(nums, j + 1, hi, k);
    }


    private int partition(int[] nums, int lo, int hi){
        int v = nums[lo];// 基准
        int left = lo, right = hi;
        while (left < right){
            while (left < right && nums[right] >= v){
                right--;
            }
            nums[left] = nums[right];

            while (left < right && nums[left] <= v){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = v;
        return left;
    }

    public static void main(String[] args) {
        SlidingWindow solution = new SlidingWindow();
        int[] leastNumbers = solution.getLeastNumbers(new int[]{0,1,2,1}, 1);
        solution.lengthOfLongestSubstring("abcabcbb");
        solution.minWindow("ADOBECODEBANC", "ABC");
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1){
                char d = s.charAt(left);
                left++;

                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }

        return res;
    }

    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<>(), window = new HashMap<>();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            need.put(tChars[i], need.getOrDefault(tChars[i], 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;

        char[] sChars = s.toCharArray();
        while (right < s.length()){
            char c = sChars[right];
            right++;

            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while (valid == need.size()){
                if (right - left < len){
                    start = left;
                    len = right - left;
                }

                char d = sChars[left];
                left++;

                if (need.containsKey(d)){
                    if (need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, start + len);
    }


}
