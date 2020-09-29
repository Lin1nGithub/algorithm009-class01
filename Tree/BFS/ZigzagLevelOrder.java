package BFS;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 二叉树的锯齿形层次遍历
 * @author linkuan
 * @version 1.0
 * @since 2020/9/6 4:27 下午
 */
public class ZigzagLevelOrder {

    List<List<Integer>> res = new ArrayList<>();

    Queue<TreeNode> queue = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (null == root){

            return res;
        }

        queue.offer(root);

        int step = 1;

        while (!queue.isEmpty()){

            int sz = queue.size();

            List<Integer> list = new ArrayList<>(sz);

            for (int i = 0; i < sz; i++){

                TreeNode node = queue.poll();

                // 偶数
                if (step % 2 == 0){

                    list.add(0,node.val);
                }else {

                    list.add(node.val);
                }

                if (node.left != null){

                    queue.offer(node.left);
                }

                if (node.right != null){

                    queue.offer(node.right);
                }
            }

            res.add(list);

            step++;
        }

        return res;
    }

}
