import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    class Solution{

    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        uniquePaths.uniquePaths(3,2);

        uniquePaths.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
    }

    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                return nums[i];
            }
        }
        return -1;
    }

    private void quickSort(int lo, int hi, int[] nums){
        if(lo > hi) return;
        int v = nums[lo];
        int left = lo, right = hi;
        while(left < right){
            while(left < right && nums[right] >= v){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] <= v){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = v;
        quickSort(lo, left - 1, nums);
        quickSort(right + 1, hi, nums);
    }
}
