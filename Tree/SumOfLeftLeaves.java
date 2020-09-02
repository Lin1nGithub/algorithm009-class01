/**
 * 左叶子之和
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * @author linkuan
 * @version 1.0
 * @since 2020/9/2 9:19 下午
 */
public class SumOfLeftLeaves {

    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root,true);
        return res;
    }

    private void traverse(TreeNode root, boolean flag){

        if (root == null){
            return;
        }

        if (root.left == null && root.right == null && flag){
            res =  res + root.val;
        }

        traverse(root.right, false);

        traverse(root.left, true);
    }
}
