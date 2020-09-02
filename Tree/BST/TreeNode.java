package BST;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/9/2 10:11 下午
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // 二叉树模版
    void traverse(TreeNode node){

        if (node == null){
            return;
        }

        // 前序遍历

        traverse(node.left);

        // 中序遍历

        traverse(node.right);

        // 后续遍历
    }
}
