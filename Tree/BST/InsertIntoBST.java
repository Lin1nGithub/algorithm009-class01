package BST;

/**
 * 二叉搜索树中的插入操作
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * @author linkuan
 * @version 1.0
 * @since 2020/9/18 17:39
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null){

            return new TreeNode();
        }

        if (val > root.val){

            root.right = insertIntoBST(root.right, val);

        }else {

            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }


}
