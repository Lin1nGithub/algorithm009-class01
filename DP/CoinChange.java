import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 322
 * 零钱兑换
 * @author linkuan
 * @version 1.0
 * @since 2020/10/12 22:50
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        if (amount == 0){

            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for (int coin : coins) {

            // 金额不可达
            if (amount - coin< 0){

                continue;
            }

            int subProb = coinChange(coins, amount - coin);

            if (subProb == -1){

                continue;
            }

            ans = Math.min(ans, subProb + 1);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // 自顶向下-备忘录
    static class TopToBottom {

        public int coinChange(int[] coins, int amount) {

            int[] memo = new int[amount + 1]; // 每个子问题总数-某个零钱的最少的硬币个数
            Arrays.fill(memo, 0);

            return helper(memo, coins, amount);
        }

        private int helper(int[] memo, int[] coins, int amount) {

            if (amount == 0) return 0;

            int ans = Integer.MAX_VALUE;

            for (int coin : coins) {

                // 金额不可达
                if (amount - coin < 0) {

                    continue;
                }

                if (memo[amount] != 0){

                    return memo[amount];
                }

                int subProb = helper(memo, coins, amount - coin);

                // 子问题无解
                if (subProb == -1) {

                    continue;
                }

                ans = Math.min(ans, subProb + 1);
            }

            memo[amount] = ans == Integer.MAX_VALUE ? -1 : ans;

            return memo[amount];
        }
    }

    /**
     * 自底向上
     */
    class BottomToTop{

        public int coinChange(int[] coins, int amount) {

            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);

            dp[0] = 0;

            for (int i = 0; i < dp.length; i++) {

                // 内层 for 在求所有子问题 + 1 的最小值
                for (int coin : coins) {

                    if (i - coin < 0) {

                        continue;
                    }

                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }

            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }

    public static void main(String[] args) {
        TopToBottom topToBottom = new TopToBottom();
        topToBottom.coinChange(new int[]{1,2,5}, 11);

    }
}
