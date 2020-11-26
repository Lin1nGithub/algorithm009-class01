import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 组合总和 II
 * 40
 * @author linkuan
 * @version 1.0
 * @since 2020/11/10 17:02
 */
public class CombinationSum2 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 关键步骤
        Arrays.sort(candidates);

        backTrack(new ArrayList<>(), 0, candidates, target);
        return res;
    }

    private void backTrack(List<Integer> path, int start, int[] candidates, int sum){
        if (sum < 0) return;
        if (sum == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum - candidates[i] < 0){
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.add(candidates[i]);
            backTrack(path, i + 1, candidates, sum - candidates[i]);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        CombinationSum2 solution = new CombinationSum2();
        solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}
