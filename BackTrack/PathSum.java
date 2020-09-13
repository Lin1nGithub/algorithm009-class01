import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 路径总和 II
 * @author linkuan
 * @version 1.0
 * @since 2020/9/8 11:52 下午
 */
public class PathSum {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){

            return res;
        }

        List<Integer> path = new ArrayList<>();

        backTrack(root, sum, path);

        return res;
    }

    private void backTrack(TreeNode root, int sum,List<Integer> path){

        path.add(root.val);

        if (root.right == null && root.left == null){

            if (sum == root.val){

                res.add(new ArrayList<>(path));

                return;
            }
        }

        if (root.left != null){

            backTrack(root.left, sum - root.val, path);

            // 撤销选择
            path.remove(path.size() - 1);
        }

        if (root.right != null){

            backTrack(root.right, sum - root.val, path);

            // 撤销选择
            path.remove(path.size() - 1);
        }

    }


}
