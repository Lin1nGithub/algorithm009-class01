import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutation-sequence/
 * 60
 * 排列序列
 * @author linkuan
 * @version 1.0
 * @since 2020/11/10 19:58
 */
public class GetPermutation {

    /**
     * 阶乘数组
     */
    private int[] factorial;

    private boolean[] used;

    private int n;
    private int k;

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        this.used = new boolean[n + 1];

        calculateFactorial(n);

        StringBuilder path = new StringBuilder();
        backTrack(path, 0);
        return path.toString();
    }

    private void backTrack(StringBuilder path, int depth){
        if (depth == n){
            return;
        }

        // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int cnt = factorial[n - 1 - depth];
        for (int i = 1; i <= n; i++) {
            if (used[i]){
                continue;
            }
            if (cnt < k){
                k -= cnt;
                continue;
            }
            used[i] = true;
            path.append(i);
            backTrack(path, depth + 1);
            return;
        }
    }

    /**
     * 5! = 5 * 4! = 5 * 4 * 3!以此类推
     * 1,2,3,4,5的全排列 =》 1,2,3,4的全排列 * 5 =》 1,2,3的全排列 * 4 =》 1,2的全排列 * 3 =》 1的全排列 * 2
     * 可得到 状态转移方程式 f(n) = f(n- 1) * n
     * @param n
     */
    private void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    public static void main(String[] args) {

        GetPermutation solution = new GetPermutation();
        solution.getPermutation(4,9);
    }
}
