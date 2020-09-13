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

    Queue<TreeNode> q = new LinkedList<>();

    Stack<TreeNode> stack = new Stack<>();


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null){

            return res;
        }

        q.offer(root);

        while (!q.isEmpty()){

            List<Integer> list = new ArrayList<>();

            while (!q.isEmpty()){

                TreeNode node = q.poll();

                list.add(node.val);

                if (node.left != null){

                    stack.push(node.left);
                }

                if (node.right != null){

                    stack.push(node.right);
                }
            }

            res.add(list);

            list = new ArrayList<>();

            while (!stack.isEmpty()){

                TreeNode node = stack.pop();

                list.add(node.val);

                if (q.isEmpty()){
                    if (node.left != null){

                        q.offer(node.left);
                    }

                    if (node.right != null){

                        q.offer(node.right);
                    }
                }
                else {
                    if (node.right != null){

                        q.offer(node.right);
                    }

                    if (node.left != null){

                        q.offer(node.left);
                    }
                }
            }

            if (list.size() > 0){

                res.add(list);
            }
        }

        return res;
    }
}
