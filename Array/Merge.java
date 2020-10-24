/**
 * v
 * 88
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * @author linkuan
 * @version 1.0
 * @since 2020/10/24 11:54
 */
public class Merge {

    /**
     * 双指针,从后向前比较 空间复杂度O(m) 时间复杂度O(m + n)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len1 >= 0 && len2 >= 0){
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
//        System.arraycopy(nums1,0,nums2, 0, len2 + 1);
        // 将数组2中剩下的值转移到数组1中
        while (len2 >= 0){
            nums1[len2] = nums2[len2--];
        }
    }
}
