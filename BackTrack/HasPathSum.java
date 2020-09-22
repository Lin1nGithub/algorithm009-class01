import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/path-sum/
 * 路径总和
 * @author linkuan
 * @version 1.0
 * @since 2020/9/6 5:52 下午
 */
public class HasPathSum {

    private boolean hasPathSum(TreeNode root,int sum){

        if (root == null){

            return false;
        }

        if (root.right == null && root.left == null){

            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
