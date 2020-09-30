import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @author linkuan
 * @version 1.0
 * @since 2020/5/31 10:39
 */
public class PreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }

    /**
     * 迭代
     * 本质上是在模拟递归，因为在递归的过程中使用了系统栈，所以在迭代的解法中常用Stack来模拟系统栈。
     *
     * 前序遍历
     * 首先我们应该创建一个Stack用来存放节点，首先我们想要打印根节点的数据，此时Stack里面的内容为空，所以我们优先将头结点加入Stack，然后打印。
     *
     * 之后我们应该先打印左子树，然后右子树。所以先加入Stack的就是右子树，然后左子树。
     *
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if(null == root){
                return res;
            }
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                res.add(node.val);
                if(null != node.right){
                    stack.push(node.right);
                }
                if(null != node.left){
                    stack.push(node.left);
                }
            }
            return res;
        }

        public List<Integer> preorderTraversalTwo(TreeNode root) {

            if (null == root){

                return null;
            }

            Stack<TreeNode> stack = new Stack<>();

            List<Integer> res = new ArrayList<>();

            TreeNode temp = root;

            while (temp != null || !stack.isEmpty()){

                if (temp != null){

                    stack.add(temp);

                    res.add(temp.val);
                    // 先遍历左子树，一直走到空
                    temp = temp.left;

                }else {

                    TreeNode node = stack.pop();

                    // 左子树走到空，就从获取已经遍历过左子树的中间结果，将它出栈，并遍历它的右子树
                    temp = node.right;
                }
            }

            return res;
        }
    }
}
