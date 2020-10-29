/**
 * 寻找两个正序数组的中位数
 * 4
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @author linkuan
 * @version 1.0
 * @since 2020/10/24 14:31
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length - 1;

        int len2 = nums2.length - 1;

        int len = nums1.length + nums2.length - 1;

        int[] nums = new int[len + 1];

        while (len1 >= 0 && len2 >= 0){
            nums[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        while (len2 >= 0){
            nums[len2] = nums2[len2--];
        }
        while (len1 >= 0){
            nums[len1] = nums1[len1--];
        }

        int index = nums.length / 2;

        if (nums.length % 2 == 1){
            return nums[index];
        }else {
            return (nums[index] + nums[index - 1]) * 0.5;
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays find = new FindMedianSortedArrays();
        System.out.println(find.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }
}
