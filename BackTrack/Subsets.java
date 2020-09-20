import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * https://leetcode-cn.com/problems/subsets/
 * @author linkuan
 * @version 1.0
 * @since 2020/9/20 5:29 下午
 */
public class Subsets {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        if (nums.length == 0){

            return res;
        }

        List<Integer> path = new ArrayList<>();

        backTrack(nums, 0 , path);

        return res;
    }

    private void backTrack(int nums[], int start, List<Integer> path){

        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++){

            // 做选择
            path.add(nums[i]);

            backTrack(nums, i + 1, path);

            // 撤回选择
            path.remove(path.size() - 1);
        }
    }
}
