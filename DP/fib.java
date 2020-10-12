import java.util.Arrays;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/10/12 21:52
 */
public class fib {

    public int fib(int N) {
        if(N <= 1){
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }

    /**
     * 备忘录版
     * https://leetcode-cn.com/problems/fibonacci-number/solution/dong-tai-gui-hua-tao-lu-xiang-jie-by-labuladong/
     * 自顶向下-- 文章
     */
    static class Solution{

        public int fib(int N) {

            if (N == 1 || N == 0) return N;

            int[] memo = new int[N + 1];
            Arrays.fill(memo, 0);

            // 初始化备忘录,减少重复计算
            memo[1] = memo[2] = 1;

            return helper(memo,N);
        }

        private int helper(int[] memo, int N){

            // 未被计算过
            if (N > 0 && memo[N] == 0){

                memo[N] = helper(memo, N - 1) + helper(memo, N - 2);
            }

            return memo[N];
        }
    }

    // 自底向上
    class BottomToTop{

        public int fib(int N) {

            if (N == 1 || N == 0) return N;

            int[] memo = new int[N + 1];
            Arrays.fill(memo, 0);

            memo[1] = 1;
            memo[2] = 1;

            for (int i = 3;i <= N; i++){

                memo[i] = memo[i - 1] + memo[i - 2];
            }

            return memo[N];
        }
    }

    /**
     * 状态转移
     */
    class StatusChange{

        int fib(int n) {
            if (n == 2 || n == 1)
                return 1;
            int prev = 1, curr = 1;
            for (int i = 3; i <= n; i++) {
                int sum = prev + curr;
                prev = curr;
                curr = sum;
            }
            return curr;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.fib(20);
    }
}
