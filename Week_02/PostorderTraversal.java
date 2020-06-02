import java.util.ArrayList;
import java.util.List;

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
}
