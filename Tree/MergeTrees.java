/**
 * 671
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * 合并二叉树
 * @author linkuan
 * @version 1.0
 * @since 2020/9/25 11:36
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null){

            return t1;
        }

        if (t1 == null){

            t1 = t2;

        }else if (t2 != null){

            t1.val += t2.val;

            t1.left = mergeTrees(t1.left, t2.left);

            t1.right = mergeTrees(t1.right, t2.right);
        }

        return t1;
    }

}
