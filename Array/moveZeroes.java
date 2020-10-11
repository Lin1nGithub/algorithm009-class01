/**
 * 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 * 移动零
 * @author linkuan
 * @version 1.0
 * @since 2020/10/9 22:55
 */
public class moveZeroes {

    public void moveZeroes(int[] nums) {

        if (null == nums || nums.length == 0){

            return;
        }

        int fast,slow;
        fast = slow = 0;

        while (fast < nums.length){

            if (nums[fast] != 0){

                nums[slow] = nums[fast];

                slow++;
            }

            fast++;
        }

        while (slow < fast){

            nums[slow] = 0;

            slow++;
        }
    }
}
