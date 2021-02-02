/**
 * 321
 * 拼接最大数
 * https://leetcode-cn.com/problems/create-maximum-number/
 * @author linkuan
 * @version 1.0
 * @since 2020/12/7 19:56
 */
public class MaxNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        return null;
    }

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

    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for (int bill : bills) {
            if (bill == 5){
                fiveCount++;
            }else if (bill == 10){
                if (--fiveCount < 0){
                    return false;
                }
                tenCount++;
            }else if (bill == 20){
                if (tenCount >= 1){
                    if (--fiveCount < 0){
                        return false;
                    }
                    tenCount--;
                }else {
                    fiveCount-= 3;
                    if (fiveCount < 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MaxNumber solution = new MaxNumber();
        System.out.println(solution.lemonadeChange(new int[]{5,5,10,10,20}));

        System.out.println(solution.uniquePaths(3, 2));
    }
}
