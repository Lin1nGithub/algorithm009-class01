/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 两数之和
 * 两数之和 II - 输入有序数组
 * @author linkuan
 * @version 1.0
 * @since 2020/11/5 10:22
 */
public class TwoSumII {

    public int[] twoSum(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if (sum == target){
                return new int[]{left + 1, right + 1};
            }else if (sum > target){
                right--;
            }else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
