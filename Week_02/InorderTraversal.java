import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
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

    /**
     * 迭代
     * 质上是在模拟递归，因为在递归的过程中使用了系统栈，所以在迭代的解法中常用Stack来模拟系统栈。
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while(stack.size() > 0 || root != null) {
                //不断往左子树方向走，每走一次就将当前节点保存到栈中
                //这是模拟递归的调用
                if(root != null) {
                    stack.add(root);
                    root = root.left;
                    //当前节点为空，说明左边走到头了，从栈中弹出节点并保存
                    //然后转向右边节点，继续上面整个过程
                } else {
                    TreeNode tmp = stack.pop();
                    res.add(tmp.val);
                    root = tmp.right;
                }
            }
            return res;
        }
    }
}
