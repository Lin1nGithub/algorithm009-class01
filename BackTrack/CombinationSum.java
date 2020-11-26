import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 39
 * @author linkuan
 * @version 1.0
 * @since 2020/11/10 16:05
 */
public class CombinationSum {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(target, new ArrayList<>(), candidates, 0);
        return res;
    }

    private void backTrack(int sum,List<Integer> path, int[] candidates, int start){
        if (sum < 0){
            return;
        }
        if (sum == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backTrack(sum - candidates[i], path, candidates, i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        CombinationSum solution = new CombinationSum();
        solution.combinationSum(new int[]{2,3,6,7}, 7);
    }
}
