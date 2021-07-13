import LRU.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author kuan.lin
 * @Date 2021/6/16 17:55
 * @Version 1.0
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        // dp[i] 以 nums[i] 结尾的连续子数组的最大和
        int[] dp = new int[nums.length];
        int res;
        res = dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
        }
        for (int i = 1; i < nums.length; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int climbStairs(int n) {
        // dp[n] 是到达第n阶台阶的不同方法次数
        int[] dp = new int[n + 1];
        dp[1] = dp[0] = 1;
        for (int i = 2; i < n + 1; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2){
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        MaxSubArray solution = new MaxSubArray();
        solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.maxProfit1(new int[]{7,1,5,3,6,4}));
    }


    public int maxProfit1(int[] prices) {
        if (prices.length < 2) return 0;
        int len = prices.length;
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++){
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }

    public int[] countBits(int n) {
        // n数中有1的数目
        int dp[] = new int[n + 1];
        return null;
    }
}
