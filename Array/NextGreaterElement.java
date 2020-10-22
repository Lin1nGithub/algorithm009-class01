import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 下一个更大的数 单调栈
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * 496
 * @author linkuan
 * @version 1.0
 * @since 2020/10/19 15:41
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];

        Map<Integer, Integer> map = nextGreaterHelper(nums2);

        for (int i = 0; i < nums1.length; i++) {

            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    private Map<Integer, Integer> nextGreaterHelper(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();  // 存放高个元素的栈
        for (int i = nums.length - 1; i >= 0; i--) {  // 倒着往栈里放
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();  // 矮个起开，反正也被挡着了
            }
            map.put(nums[i], stack.isEmpty() ? -1 : stack.peek());  // 当前元素身后的第一个高个
            stack.push(nums[i]);  // 进队，接受之后的身高判定
        }
        return map;
    }
}
