import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/
 * 不同字符的最小子序列
 *  1081
 * @author linkuan
 * @version 1.0
 * @since 2020/11/16 19:59
 */
public class SmallestSubsequence {

    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }
        Deque<Character> dq = new LinkedList<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = charArray[i];
            if (visited[c - 'a']){
                continue;
            }
            while (!dq.isEmpty() && dq.peekLast() > c && lastIndex[dq.peekLast() - 'a'] > i){
                int top = dq.pollLast();
                visited[top - 'a'] = false;
            }
            dq.offerLast(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()){
            sb.append(dq.pollFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SmallestSubsequence solution = new SmallestSubsequence();
        solution.smallestSubsequence("bcabc");
        solution.removeKdigits("1432219", 3);
    }
    public String removeKdigits(String num, int k) {
        if (num.length() < k) return "0";
        Deque<Character> dq = new LinkedList<>();
        char[] charArray = num.toCharArray();
        for (int i = 0; i < num.length(); i++) {
            char c = charArray[i];
            while (!dq.isEmpty() && c < dq.peekLast() && k > 0){
                dq.pollLast();
                k--;
            }
            if (!dq.isEmpty() || c != '0'){
                dq.offerLast(c);
            }
        }
        while (k > 0 && !dq.isEmpty()){
            dq.pollLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()){
            sb.append(dq.pollFirst());
        }
        return sb.length() == 0 ?
                "0" : sb.toString();
    }

}
