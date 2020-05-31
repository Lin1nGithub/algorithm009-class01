import java.util.ArrayList;
import java.util.List;

/**
 * 树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @author linkuan
 * @version 1.0
 * @since 2020/5/31 10:39
 */
public class InorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List< Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList< >();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}
