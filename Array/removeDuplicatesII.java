/**
 * 删除排序数组中的重复项 II
 * 80
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * @author linkuan
 * @version 1.0
 * @since 2020/10/9 22:16
 */
public class removeDuplicatesII {

    public int removeDuplicates(int[] nums) {

        //
        // Initialize the counter and the second pointer.
        //
        int slow = 1, count = 1;

        //
        // Start from the second element of the array and process
        // elements one by one.
        //
        for (int fast = 1; fast < nums.length; fast++) {

            //
            // If the current element is a duplicate, increment the count.
            //
            if (nums[fast] == nums[fast - 1]) {

                count++;

            } else {

                //
                // Reset the count since we encountered a different element
                // than the previous one.
                //
                count = 1;
            }

            //
            // For a count <= 2, we copy the element over thus
            // overwriting the element at index "j" in the array
            //
            if (count <= 2) {

                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
