package CBT;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * 完全二叉树的节点个数
 * @author linkuan
 * @version 1.0
 * @since 2020/9/14 10:52 下午
 */

public class CountNodes {

    Queue<TreeNode> q = new LinkedList<>();

    int count = 0;

    public int countNodes(TreeNode root) {

        if (root == null){

            return count;
        }

        q.offer(root);

        while (!q.isEmpty()){

            int sz = q.size();

            for (int i = 0; i < sz; i++){

                TreeNode node = q.poll();

                if (node.left != null){

                    q.offer(node.left);
                }

                if (node.right != null){

                    q.offer(node.right);
                }

                count++;
            }
        }

        return count;
    }
}
