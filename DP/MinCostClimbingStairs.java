/**
 * 使用最小花费爬楼梯
 * 746
 * @author linkuan
 * @version 1.0
 * @since 2020/12/21 20:29
 */
public class MinCostClimbingStairs {

    // 假如要到达某一层，只要考虑两件事：是从楼下走1层上来，还是从楼下的楼下跨2层上来。

    public int minCostClimbingStairs(int[] cost) {

        int size = cost.length;

        int down = 0, downdown = 0;

        for(int i = 2; i <= size; i++){

            int cur = Math.min(cost[i - 1] + down, cost[i - 2] + downdown); // 到当前楼层两种路径消耗的体力最小值

            downdown = down; // 及时更新便于下一层循环，楼下就变成了楼下的楼下

            down = cur; // 当前楼层就变成了楼下
        }
        return down; // 本该返回cur，不过cur是局部变量，但到达当前楼层的体力值cur在循环里已经赋值给了down
    }

    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
