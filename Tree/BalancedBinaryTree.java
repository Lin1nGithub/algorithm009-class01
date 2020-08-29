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
}
