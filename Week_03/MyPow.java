/**
 * 分治
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * https://leetcode-cn.com/problems/powx-n/
 *
 * @author linkuan
 * @version 1.0
 * @since 2020/6/15 20:50
 */
public class MyPow {
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    class Solution {
        public double myPow(double x, long n){
            long N = n;
            if(N < 0){
                x = 1 / x;
                N = -N;
            }
            double asn = 1;
            for(long i = 0; i < N; i++ ){
                asn =  asn * x;
            }
            return asn;
        }
    }
}
