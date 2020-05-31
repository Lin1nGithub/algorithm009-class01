/**
 * 丑数（动态规划，清晰图解）
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 * @author linkuan
 * @version 1.0
 * @since 2020/5/31 10:39
 */
public class NthUglyNumber {

    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }


}
