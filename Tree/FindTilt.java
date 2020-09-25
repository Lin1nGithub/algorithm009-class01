/**
 * 563
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 * 二叉树的坡度
 * @author linkuan
 * @version 1.0
 * @since 2020/9/25 14:39
 */
public class FindTilt {

    int tilt = 0;

    public int findTilt(TreeNode root) {

        postorder(root);

        return tilt;
    }


    private int postorder(TreeNode root){

        if (root == null){

            return 0;
        }

        int left = postorder(root.left);

        int right = postorder(root.right);

        tilt += Math.abs(left - right);

        return left + right + root.val;
    }

}
