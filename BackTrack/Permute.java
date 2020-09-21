import java.util.ArrayList;
import java.util.List;

/**
 * 全排列-回溯算法
 * https://leetcode-cn.com/problems/permutations/
 *
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 * @author linkuan
 * @version 1.0
 * @since 2020/8/31 21:26
 */
public class Permute {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        int len = nums.length;

        if (len == 0){

            return res;
        }

        List<Integer> path = new ArrayList<>();

        boolean[] used = new boolean[len];

        backtrack(nums, 0 , path, used);

        return res;
    }

    public void backtrack(int nums[], int depth,List<Integer> path, boolean[] used){

        if (depth == nums.length){

            res.add(new ArrayList<>(path));

            return;
        }

        for (int i = 0; i < nums.length ; i++){

            if (!used[i]){

                path.add(nums[i]);

                used[i] = true;

                backtrack(nums, depth + 1, path, used);

                path.remove(path.size() - 1);

                used[i] = false;
            }
        }
    }
}
