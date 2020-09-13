/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * 求根到叶子节点数字之和
 * @author linkuan
 * @version 1.0
 * @since 2020/9/12 4:00 下午
 */
public class SumNumbers {

    public int sumNumbers(TreeNode root) {

        return traverse(root, 0);

    }

    private int traverse(TreeNode root,int sum){

        if (null == root){

            return 0;
        }

        int tmp = sum * 10 + root.val;

        if (root.left == null && root.right == null){

            return tmp;
        }

        return traverse(root.left,tmp) + traverse(root.right, tmp);
    }

}
