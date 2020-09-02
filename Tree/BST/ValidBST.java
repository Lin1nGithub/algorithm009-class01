package BST;

/**
 * 验证二叉搜索树-中序遍历
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author linkuan
 * @version 1.0
 * @since 2020/9/2 10:09 下午
 */
public class ValidBST {

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        if (!isValidBST(root.left)){
            return false;
        }

        if (pre >= root.val){
            return false;
        }

        pre = root.val;

        if (!isValidBST(root.right)){
            return false;
        }

        return true;
    }
}
