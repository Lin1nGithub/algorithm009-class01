import SlidingWindow.MaxSlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 有效的括号
 * 20
 * @author linkuan
 * @version 1.0
 * @since 2020/11/10 14:15
 */
public class IsValid {

    public boolean isValid(String s) {
        if (s.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || s.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid solution = new IsValid();
        solution.isValid("()[]{}");
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1){
                window.put(nums[i]);
            }else {
                window.put(nums[i]);
                res.add(window.max());
                window.pop(nums[i]);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    static class MonotonicQueue{
        private LinkedList<Integer> q = new LinkedList<>();

        private void put(int n){
            while (!q.isEmpty() && q.getLast() < n){
                q.pollLast();
            }
            q.offerLast(n);
        }

        private int max(){
            return q.getFirst();
        }

        private void pop(int n){
            if (n == q.getFirst()){
                q.pollFirst();
            }
        }
    }
}
