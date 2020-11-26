import java.util.*;

/**
 * 独一无二的出现次数
 * 1027
 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
 * @author linkuan
 * @version 1.0
 * @since 2020/11/25 16:43
 */
public class UniqueOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            counter.put(arr[i], counter.getOrDefault(arr[i],0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (set.contains(entry.getValue())){
                return false;
            }else {
                set.add(entry.getValue());
            }
        }
        return true;
    }

    public boolean isValid(String s) {
        if (s.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(')');
            }else if (s.charAt(i) == '{'){
                stack.push('}');
            }else if (s.charAt(i) == '['){
                stack.push(']');
            }else if (stack.isEmpty() || s.charAt(i) != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 1662
     * 检查两个字符串数组是否相等
     * @param word1
     * @param word2
     * @return
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int idx1 = 0, idx2 = 0, arrIdx1 = 0, arrIdx2 = 0;
        while (arrIdx1 < word1.length && arrIdx2 < word2.length) {
            if (word1[arrIdx1].charAt(idx1) != word2[arrIdx2].charAt(idx2)) return false;
            if (idx1 == word1[arrIdx1].length() - 1) {
                idx1 = 0;
                arrIdx1++;
            } else {
                idx1++;
            }
            if (idx2 == word2[arrIdx2].length() - 1) {
                idx2 = 0;
                arrIdx2++;
            } else {
                idx2++;
            }
        }
        return arrIdx1 == word1.length && arrIdx2 == word2.length;
    }

    public static void main(String[] args) {

        UniqueOccurrences solution = new UniqueOccurrences();
        solution.isValid("()[]{}");
    }
}
