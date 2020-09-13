/**
 * @author linkuan
 * @version 1.0
 * @since 2020/9/6 5:12 下午
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {

        if (root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);

        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
