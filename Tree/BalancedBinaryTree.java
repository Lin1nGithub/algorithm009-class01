import java.util.ArrayList;
import java.util.List;

/**
 * 平衡二叉树
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * @author linkuan
 * @version 1.0
 * @since 2020/8/29 16:26
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    /**
     * 自底向上
     * @param node
     * @return
     */
    int height(TreeNode node){
        if (node == null){

            return 0;
        }

        int leftHeight =  height(node.left);

        int rightHeight = height(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){

            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null){

            return res;
        }

        backTrack(root, new ArrayList<>(), sum);

        return res;
    }

    private void backTrack(TreeNode root, List<Integer> path, int sum){

        path.add(root.val);

        if (root.right == null && root.left == null){

            if (root.val == sum){

                res.add(new ArrayList<>(path));

                return;
            }
        }

        if (root.left != null){

            backTrack(root.left, path, sum - root.val);

            path.remove(path.size() - 1);
        }

        if (root.right != null){

            backTrack(root.right, path,sum - root.val);

            path.remove(path.size() - 1);
        }
    }
}
