package NumberSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 18
 * @author linkuan
 * @version 1.0
 * @since 2020/11/27 14:24
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        quickSort(nums, 0 ,nums.length - 1);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1  && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)break;
                if (nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) continue;
                int left = j + 1, right = nums.length - 1;
                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target){
                        while (left < right && nums[right] == nums[--right]);
                    }else if (sum < target){
                        while (left < right && nums[left] == nums[++left]);
                    }else {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        while (left < right && nums[right] == nums[--right]);
                        while (left < right && nums[left] == nums[++left]);
                    }
                }
            }
        }
        return res;
    }

    private void quickSort(int[] nums, int lo, int hi){
        if (lo > hi) return;
        int v = nums[lo];
        int left = lo, right = hi;
        while (left < right){
            while (left < right && nums[right] >= v){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= v){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = v;
        quickSort(nums, lo, left - 1);
        quickSort(nums, right + 1, hi);
    }

    public static void main(String[] args) {
        FourSum solution = new FourSum();
        solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }
}
