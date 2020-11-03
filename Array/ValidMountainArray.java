/**
 * 有效的山脉
 * 941
 * https://leetcode-cn.com/problems/valid-mountain-array/
 * @author linkuan
 * @version 1.0
 * @since 2020/11/3 11:11
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int left = 0, right = A.length - 1;
        while (left < right && A[left] < A[left + 1]){
            left++;
        }
        while (right > left && A[right] < A[right - 1]){
            right--;
        }
        return left > 0 && right < A.length - 1 && left == right;
    }

    public static void main(String[] args) {

        ValidMountainArray solution = new ValidMountainArray();
        solution.validMountainArray(new int[]{0,1,2,3,4,5,6,7,8,9});
    }
}
