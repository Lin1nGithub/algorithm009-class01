package BinarySearch;

/**
 * 287
 * 寻找重复数
 * @author linkuan
 * @version 1.0
 * @since 2020/12/14 14:29
 */
public class FindDuplicate {

    public static void main(String[] args) {
        FindDuplicate solution = new FindDuplicate();
        solution.findDuplicate(new int[]{2, 4, 5, 2, 3, 1, 6, 7});
    }

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        // 二分法左右指针差值最小为1，而left=mid+1可以破坏循环条件，即left=right
        while (left < right){
            int mid = left + right >>> 1;
            int cnt = 0;
            for (int num : nums){
                if (num <= mid){
                    cnt++;
                }
            }
            if (cnt > mid){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
