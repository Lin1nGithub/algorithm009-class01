import java.util.Arrays;

/**
 * 不同路径
 * 62
 * 残酷群视频第一题
 * https://leetcode-cn.com/problems/unique-paths/
 * @author linkuan
 * @version 1.0
 * @since 2020/11/6 10:17
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; // dp[m][n] 代表走到该位置需要的步数
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        uniquePaths.uniquePaths(1,1);
    }
}
