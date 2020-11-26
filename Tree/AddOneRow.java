import javafx.scene.shape.ArcTo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/add-one-row-to-tree/
 * 623
 * 在二叉树中增加一行
 * @author linkuan
 * @version 1.0
 * @since 2020/9/28 18:31
 */
public class AddOneRow {

    Queue<TreeNode> queue = new LinkedList<>();

    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if (d == 1){

            TreeNode temp = root;

            root = new TreeNode(v);

            root.left = temp;
        }

        int step = 1;

        queue.offer(root);

        while (!queue.isEmpty()){

            int sz = queue.size();

            if (step == d){

                break;
            }

            for (int i = 0; i < sz; i++) {

                TreeNode node = queue.poll();

                if (node.left != null){

                    queue.offer(node.left);
                }

                if (node.right != null){

                    queue.offer(node.right);
                }

                if (d -1 > 0 && step == d - 1){

                    TreeNode left = node.left;

                    TreeNode right = node.right;

                    node.left = new TreeNode(v);

                    node.right = new TreeNode(v);

                    node.left.left = left;

                    node.right.right = right;
                }
            }

            step++;
        }

        return root;
    }
}
