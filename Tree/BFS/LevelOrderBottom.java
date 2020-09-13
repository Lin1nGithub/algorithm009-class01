package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历 II
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @author linkuan
 * @version 1.0
 * @since 2020/9/8 11:19 下午
 */
public class LevelOrderBottom {

    List<List<Integer>> res = new ArrayList<>();

    Queue<TreeNode> queue = new LinkedList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null){

            return res;
        }

        queue.offer(root);
        while (!queue.isEmpty()){

            List<Integer> list = new ArrayList<>();
            int sz = queue.size();
            for (int i = 0; i < sz ; i ++){

                TreeNode node = queue.poll();

                list.add(node.val);

                if (node.left != null){

                    queue.offer(node.left);
                }

                if (node.right != null){

                    queue.offer(node.right);
                }

            }

            res.add(0, list);
        }

        return res;
    }
}
