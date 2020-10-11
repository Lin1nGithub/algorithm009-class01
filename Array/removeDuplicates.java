/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 26
 * 删除排序数组中的重复项
 * @author linkuan
 * @version 1.0
 * @since 2020/10/9 22:16
 */
public class removeDuplicates {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0){

            return 0;
        }

        int fast,slow;
        fast = slow = 0;

        while (fast < nums.length){

            if (nums[fast] != nums[slow]){

                slow++;

                nums[slow] = nums[fast];
            }

            fast++;
        }

        return slow + 1;
    }
}
