/**
 * 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 * @author linkuan
 * @version 1.0
 * @since 2020/5/22 10:39
 */
public class MoveZeroes {

    /**
     * 我们使用两个指针i和j，只要nums[i]!=0，我们就交换nums[i]和nums[j]
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                int temp = nums[i];
                nums[j] = nums[i];
                nums[j++] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int []{1,2,3,0,0,5,0,4,0};
        moveZeroes(nums);
    }
}
