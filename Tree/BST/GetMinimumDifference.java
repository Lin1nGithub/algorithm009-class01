package BST;

/**
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * 二叉搜索树的最小绝对差
 * 530,783
 * @author linkuan
 * @version 1.0
 * @since 2020/10/12 11:46
 *
 * 二叉搜索树中序遍历得到的值序列是递增有序的,获取最小绝对值肯定是两个相邻节点间的最小值
 */
public class GetMinimumDifference {

    int pre = -1;

    int diff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        inorder(root);

        return diff;
    }

    private void inorder(TreeNode root){
        if (root == null){

            return;
        }
        inorder(root.left);

        if (pre ==  -1){

            pre = root.val;
        }else {

            diff = Math.min(diff, Math.abs(root.val - pre));

            pre = root.val;
        }

        inorder(root.right);
    }
}
