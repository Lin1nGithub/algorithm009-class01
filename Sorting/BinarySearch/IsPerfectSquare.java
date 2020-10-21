package BinarySearch;

/**
 * https://leetcode-cn.com/problems/valid-perfect-square/
 * 367
 * 有效的完全平方数
 * @author linkuan
 * @version 1.0
 * @since 2020/10/13 10:22
 */
public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if(num == 0) return false;
        long left = 0;
        long right = num;
        long mid = 1;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(mid * mid == num){
                return true;
            }else if(mid * mid > num){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
