import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 翻转二叉树
 * @author linkuan
 * @version 1.0
 * @since 2020/9/14 10:35 下午
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {

        traverse(root);

        return root;
    }

    private void traverse(TreeNode root){
        if (null == root){
            return;
        }

        TreeNode temp  = root.left;

        root.left = root.right;

        root.right = temp;

        traverse(root.left);

        traverse(root.right);
    }
}
