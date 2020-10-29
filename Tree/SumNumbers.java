import java.util.LinkedList;
import java.util.Queue;

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


    static class Solution{
        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int sum = 0;
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            Queue<Integer> numQueue = new LinkedList<>();
            nodeQueue.offer(root);
            numQueue.offer(root.val);
            while (!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.poll();
                int num = numQueue.poll();
                TreeNode left = node.left, right = node.right;
                if (left == null && right == null) {
                    sum += num;
                } else {
                    if (left != null) {
                        nodeQueue.offer(left);
                        numQueue.offer(num * 10 + left.val);
                    }
                    if (right != null) {
                        nodeQueue.offer(right);
                        numQueue.offer(num * 10 + right.val);
                    }
                }
            }
            return sum;
        }
    }
}
