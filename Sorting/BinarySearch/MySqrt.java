package BinarySearch;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 * 69
 * x 的平方根
 * @author linkuan
 * @version 1.0
 * @since 2020/10/13 10:22
 */
public class MySqrt {

    /**
     * 二分查找条件
     * 1.单调性
     * 2.有区间
     * 3.存在索引
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if(x == 0 || x == 1)return x;
        long left,right;
        left = 1;right = x;
        long mid = 1;
        while (left <= right){
            mid = left + (right - left) / 2;
            if (mid * mid > x){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return (int)right;
    }
}
