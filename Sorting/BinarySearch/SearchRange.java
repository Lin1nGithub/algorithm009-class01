package BinarySearch;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 31
 * @author linkuan
 * @version 1.0
 * @since 2020/12/1 10:39
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int left = leftBond(nums, target);
        int right = rightBond(nums, target);
        return new int[]{left,right};
    }

    private int leftBond(int[] nums, int target){
        if (nums.length == 0)return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;

            if (nums[mid] == target){

                right = mid - 1;
            }else if (nums[mid] < target){

                left = mid + 1;

            }else if (nums[mid] > target){

                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target){

            return -1;
        }
        return left;
    }

    private int rightBond(int[] nums, int target){
        if (nums.length == 0)return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right){

            int mid = left + (right - left) / 2;

            if (nums[mid] == target){

                left = mid + 1;
            }else if (nums[mid] < target){

                left = mid + 1;
            }else if (nums[mid] > target){

                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target){
            return -1;
        }
        return right;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++){

        }
        return nums;
    }
}
