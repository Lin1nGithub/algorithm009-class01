import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 * @author linkuan
 * @version 1.0
 * @since 2020/9/18 16:38
 */
public class PermuteUnique {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        if (nums.length == 0){

            return res;
        }

        // 将数组排序成有序的
        Arrays.sort(nums);

        List<Integer> path = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        backTrack(nums, 0, path, used);

        return res;
    }

    private void backTrack(int nums[], int depth , List<Integer> path, boolean[] used){

        if (nums.length == depth){

            res.add(new ArrayList<>(path));

            return;
        }

        for (int i = 0; i < nums.length; i++){

            // 使用过的值剪枝
            if (used[i]){

                continue;
            }

            // 已经使用过的前一个值 剪枝
            // 比较前一个和后一个的值 如果相等则剪枝
            if (i > 0 && used[i - 1] == false && nums[i] == nums[i - 1]){

                continue;
            }

            path.add(nums[i]);

            used[i] = true;

            backTrack(nums, depth + 1, path, used);

            path.remove(path.size() - 1);

            used[i] = false;
        }
    }

}
