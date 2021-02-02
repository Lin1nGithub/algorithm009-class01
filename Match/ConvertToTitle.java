/**
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 * Excel表列名称
 * 168
 * @author linkuan
 * @version 1.0
 * @since 2020/11/13 18:40
 */
public class ConvertToTitle {

    public String convertToTitle(int n) {
        return null;
    }

    public int[] searchRange(int[] nums, int target) {
        int lo = left(nums, target);
        int hi = right(nums, target);
        return new int[]{lo, hi};
    }

    private int left(int[] nums, int target){
        if(nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] == target){
                right = mid - 1;
            }
        }
        if(left < 0 || nums[left] != target){
            return  -1;
        }
        return left;
    }

    private int right(int[] nums, int target){
        if(nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] == target){
                left = mid + 1;
            }
        }
        if(right >=nums.length || nums[right] != target){
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {

        ConvertToTitle solution = new ConvertToTitle();
        solution.searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
}
