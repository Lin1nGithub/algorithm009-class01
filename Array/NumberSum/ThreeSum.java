package NumberSum;

import java.util.*;

/**
 * 三数之和
 * 15
 * @author linkuan
 * @version 1.0
 * @since 2020/11/27 11:15
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // 排序
        quickSort(nums, 0, nums.length - 1);
        for (int k = 0; k < nums.length - 2; k++) {
            // nums[k] + num[i] + num[j] == 0 则 nums[k] 必须小于0
            if (nums[k] > 0) continue;
            // num[k] 和 num[k - 1]相等跳过
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0){
                    while (i < j && nums[i] == nums[++i]);
                }else if (sum > 0){
                    while(i < j && nums[j] == nums[--j]);
                }else {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
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
        quickSort(nums, right + 1,hi);
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
