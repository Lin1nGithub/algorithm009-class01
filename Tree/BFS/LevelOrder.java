package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 二叉树的层序遍历
 * @author linkuan
 * @version 1.0
 * @since 2020/9/6 4:18 下午
 */
public class LevelOrder {

    List<List<Integer>> res = new ArrayList<>();

    Queue<TreeNode> q = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null){

            return res;
        }

        q.offer(root);
        while (!q.isEmpty()){

            List<Integer> list = new ArrayList<>();

            int sz = q.size();
            for (int i = 0; i < sz ; i++){

                TreeNode node = q.poll();

                list.add(node.val);

                if (node.left != null){
                    q.offer(node.left);
                }

                if (node.right != null){
                    q.offer(node.right);
                }
            }

            res.add(list);
        }

        return res;
    }

}
