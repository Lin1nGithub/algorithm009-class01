import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 二叉树展开为链表
 * @author linkuan
 * @version 1.0
 * @since 2020/9/11 9:01 下午
 */
public class Flatten {

    List<Integer> res = new LinkedList<>();

    public void flatten(TreeNode root) {

        traverse(root);
    }

    private void traverse(TreeNode root){

        if (root == null){
            return;
        }

        traverse(root.left);

        traverse(root.right);

        TreeNode temp = root.right;

        root.right = root.left;

        root.left = null;

        while (root.right != null){

            root = root.right;
        }

        root.right = temp;
    }

}
