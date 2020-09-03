package BST;

/**
 *
 * 恢复二叉搜索树
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * @author linkuan
 * @version 1.0
 * @since 2020/9/2 10:53 下午
 */
public class RecoverTree {

    TreeNode firstNode = null;

    TreeNode secondNode = null;

    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        order(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    public void order(TreeNode root){
        if (null == root){
            return;
        }

        order(root.left);

        if (null == firstNode && preNode.val > root.val){
            firstNode = preNode;
        }

        if (null != firstNode && preNode.val > root.val){
            secondNode = root;
        }

        preNode = root;

        order(root.right);
    }
}
