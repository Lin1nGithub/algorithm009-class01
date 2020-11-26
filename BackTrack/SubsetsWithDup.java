import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/10 18:11
 */
public class SubsetsWithDup {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 排序
        quickSort(nums, 0, nums.length - 1);
        Arrays.sort(nums);
        backTrack(new ArrayList<>(), 0, nums);
        return res;
    }

    private void backTrack(List<Integer> path, int start, int[] nums){
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]){
                continue;
            }
            path.add(nums[i]);
            backTrack(path, i + 1, nums);
            path.remove(path.size() - 1);
        }
    }

    private void quickSort(int[] nums, int lo, int hi){
        if (lo > hi) return;
        int left = lo, right = hi;
        int v = nums[lo];
        while (left < right){
            while (right > left && nums[right] >= v){
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
        SubsetsWithDup solution = new SubsetsWithDup();
        solution.subsetsWithDup(new int[]{2,2,1});
    }
}
