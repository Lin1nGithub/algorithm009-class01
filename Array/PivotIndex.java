/**
 * 前缀和 算法
 * https://leetcode-cn.com/problems/find-pivot-index/
 * 724
 * @author linkuan
 * @version 1.0
 * @since 2020/10/29 16:32
 */
public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int sum,leftSum;
        sum = leftSum = 0;
        // 求得总和
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            // 总和减去索引项的值 等于左边的和
            if (sum - nums[i] == leftSum){
                return i;
            }
            sum -= nums[i];
            leftSum += nums[i];
        }
        return -1;
    }

    class Solution{
        public int pivotIndex(int[] nums) {
            if (nums.length == 0) return -1;
            int left = 0;
            int right = nums.length;
            while (left < right){
                int leftSum = 0;
                for (int i = 0; i < left; i++){
                    leftSum += nums[i];
                }
                int rightSum = 0;
                for (int i = left + 1; i < right; i++){
                    rightSum += nums[i];
                }
                if (leftSum == rightSum){
                    return left;
                }
                left++;
            }
            return -1;
        }
    }
}
