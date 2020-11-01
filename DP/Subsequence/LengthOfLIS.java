package Subsequence;

import java.util.Arrays;

/**https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 最长上升子序列
 * 300
 * @author linkuan
 * @version 1.0
 * @since 2020/10/28 11:13
 */
public class LengthOfLIS {

    /**
     * 1.首先明确 dp 数组所存数据的含义。
     * 2.根据 dp 数组的定义，运用数学归纳法的思想，假设 dp[0...i−1] 都已知，想办法求出 dp[i]，一旦这一步完成，整个题目基本就解决了。
     *
     * 「子序列」和「子串」这两个名词的区别，子串一定是连续的，而子序列不一定是连续的。
     * 最长上升子序列 拆分成小问题-每个数字的最长上升子序列
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length]; // dp[i] = nums数组下标的数字的最长上升子序列长度
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 1;
        // 取得结果
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        lengthOfLIS.lengthOfLIS(new int[]{1,4,3,4,2,3});

        lengthOfLIS.pivotIndex(new int[]{-1,-1,-1,0,1,1});
    }

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
