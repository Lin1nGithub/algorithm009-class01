package Subsequence;

import java.util.Arrays;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/10/28 19:12
 */
public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];// dp[i]表示 nums[i]在数组中最长递增子序列的长度
        Arrays.fill(dp,1);
        return 0;
    }
}
