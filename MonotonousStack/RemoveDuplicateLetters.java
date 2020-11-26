import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 * 316
 * 去除重复字母
 * @author linkuan
 * @version 1.0
 * @since 2020/11/16 17:04
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        // 记录字符出现的最后位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        boolean[] visited = new boolean[26];// 字符是否被放入dq中
        Deque<Character> dq = new LinkedList<>();// 存放最后输出的字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果栈中已经存在，就跳过
            if (visited[c - 'a']){
                continue;
            }
            // 1.在栈非空，2.当前元素字典序 < 栈顶元素，3.栈顶元素在以后还会出现，弹出栈元素
            while (!dq.isEmpty() && c < dq.peekLast() && lastIndex[dq.peekLast() - 'a'] > i){
                char top = dq.pollLast();
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

        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();
        solution.removeDuplicateLetters("bcabc");
    }
}
