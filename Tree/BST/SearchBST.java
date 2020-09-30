package BST;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * 二叉搜索树中的搜索
 * @author linkuan
 * @version 1.0
 * @since 2020/9/30 14:59
 */
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null){

            return null;
        }

        if (root.val > val){

            return searchBST(root.left, val);

        }else if (root.val < val){

            return searchBST(root.right, val);
        }else {

            return root;
        }
    }
}
