/**
 * 移除元素
 * 27
 * https://leetcode-cn.com/problems/remove-element/
 * @author linkuan
 * @version 1.0
 * @since 2020/10/9 22:48
 */
public class removeElement {

    public int removeElement(int[] nums, int val) {

        if (null == nums || nums.length == 0){

            return 0;
        }

        int fast,slow;
        fast = slow = 0;

        // nums[slow]赋值然后再给slow++，
        // 这样可以保证nums[0..slow-1]是不包含值为val的元素的，
        // 最后的结果数组长度就是slow。
        while (fast < nums.length){

            if (val != nums[fast]){

                nums[slow] = nums[fast];

                slow++;
            }

            fast++;
        }

        return slow;
    }
}
