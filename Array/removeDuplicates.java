import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 26
 * 删除排序数组中的重复项
 * @author linkuan
 * @version 1.0
 * @since 2020/10/9 22:16
 */
public class removeDuplicates {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0){

            return 0;
        }

        int fast,slow;
        fast = slow = 0;

        while (fast < nums.length){

            if (nums[fast] != nums[slow]){

                slow++;

                nums[slow] = nums[fast];
            }

            fast++;
        }

        return slow + 1;
    }

    /**
     * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
     * 删除字符串中的所有相邻重复项
     */
    static class Solution{

        public String removeDuplicates(String S) {

            char[] chars = S.toCharArray();

            Stack<Character> stack = new Stack<>();

            for (char c : chars) {

                if (stack.isEmpty() || !stack.peek().equals(c)){

                    stack.push(c);
                }else {

                    stack.pop();
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!stack.isEmpty()){

                sb.append(stack.pop());
            }

            return sb.reverse().toString();
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.removeDuplicates("abbaca"));
    }
}
