package Palindrome;

/**
 * 最长回文长串
 * 5
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author linkuan
 * @version 1.0
 * @since 2020/10/30 15:10
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 奇数
            String s1 = palindrome(s, i, i);
            // 偶数
            String s2 = palindrome(s, i, i + 1);
            // longest(res, s1, s2);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private String palindrome(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--; right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
