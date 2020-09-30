import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 丑数（动态规划，清晰图解）
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 * @author linkuan
 * @version 1.0
 * @since 2020/6/2 20:05
 */
public class PostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> PostorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res){
        if (null == node){
            return;
        }
        if (null != node.left){
            helper(node.left, res);
        }else if (null != node.right){
            helper(node.right,res);
        }
        res.add(node.val);
    }

    class Solution{

        LinkedList<Integer> res = new LinkedList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            if (null == root){
                return res;
            }
            stack.add(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pollLast();
                res.addFirst(node.val);
                if (null != node.left){
                    stack.add(node.left);
                }
                if (null != node.right){
                    stack.add(node.right);
                }
            }
            return res;
        }

        public List<Integer> postorderTraversalTwo(TreeNode root) {

            Stack<TreeNode> stack = new Stack<>();

            TreeNode temp = root;

            List<Integer> res = new ArrayList<>();

            while (temp != null || !stack.isEmpty()){

                if (temp != null){

                    stack.add(temp);

                    res.add(0, temp.val);

                    temp = temp.right;

                }else {

                    TreeNode node = stack.pop();

                    temp = node.left;
                }
            }

            return res;
        }
    }
}
