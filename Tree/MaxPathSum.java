import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 二叉树中的最大路径和
 * @author linkuan
 * @version 1.0
 * @since 2020/9/12 4:25 下午
 */
public class MaxPathSum {

    int val = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        traverse(root);

        return val;
    }

    private int traverse(TreeNode root){

        if (null == root){

            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int left = Math.max(traverse(root.left), 0);
        int right = Math.max(traverse(root.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int price = left + right + root.val;

        // 更新答案
        val = Math.max(val, price);

        // 返回节点的最大贡献值
        return root.val + Math.max(left,right);
    }

}
