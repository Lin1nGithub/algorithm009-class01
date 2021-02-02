import java.util.Arrays;

/**
 * 打家劫舍
 * 198
 * https://leetcode-cn.com/problems/house-robber/
 * @author linkuan
 * @version 1.0
 * @since 2020/11/6 10:59
 */
public class Rob {

    /**
     * 这轮抢劫的最大收益 是取决于 上房不抢（上上房抢的最大收益） + 这房抢的收益 或者 这轮不抢 + 上房抢的最大收益
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];// dp[i]第i个房的最大收益
        Arrays.fill(dp, 0);
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {

        Rob solution = new Rob();
        solution.rob(new int[]{1,2,3,1});

        System.out.println(solution.candy(new int[]{0,1,2,5,3,2,7}));
    }

    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left,1);
        Arrays.fill(right, 1);
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }
        int count = left[ratings.length - 1];
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}
