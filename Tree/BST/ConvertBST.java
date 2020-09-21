package BST;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 *  把二叉搜索树转换为累加树
 * @author linkuan
 * @version 1.0
 * @since 2020/9/21 15:03
 */
public class ConvertBST {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {

        traverse(root);

        return root;
    }

    private void traverse(TreeNode root){

        if (root == null){

            return;
        }

        traverse(root.right);

        sum += root.val;

        root.val = sum;

        traverse(root.left);

    }
}
