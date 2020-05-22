/**
 * 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author linkuan
 * @version 1.0
 * @since 2020/5/22 10:39
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0;
        for(int j = 1; j < nums.length ; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i - 1;
    }
}
