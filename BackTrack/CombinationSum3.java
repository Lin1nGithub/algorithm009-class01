import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * 组合总和 III
 * 216
 * @author linkuan
 * @version 1.0
 * @since 2020/11/10 19:01
 */
public class CombinationSum3 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        backTrack(new ArrayList<>(), 0, n, 0, k, nums);
        return res;
    }

    private void backTrack(List<Integer> path, int start, int n, int depth, int k,int[] nums){
        if (k == depth){
            if (n == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (n - nums[i] < 0){
                break;
            }
            path.add(nums[i]);
            backTrack(path, i + 1, n - nums[i], depth + 1, k, nums);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum3 solution = new CombinationSum3();
        solution.combinationSum3(3, 7);
    }
}
