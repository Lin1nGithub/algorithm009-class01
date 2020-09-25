package NTree;

import java.util.*;

/**
 * 429
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * N叉树的层序遍历
 * @author linkuan
 * @version 1.0
 * @since 2020/9/25 15:34
 */
public class LevelOrder {

    List<List<Integer>> res = new ArrayList<>();

    Queue<Node> queue = new LinkedList<>();

    public List<List<Integer>> levelOrder(Node root) {

        if (null == root){

            return res;
        }

        queue.offer(root);

        while (!queue.isEmpty()){

            int sz = queue.size();

            List<Integer> list = new ArrayList<>(sz);
            res.add(list);

            for (int i = 0; i < sz ; i++){

                Node node = queue.poll();

                list.add(node.val);

                List<Node> childs = node.children;

                if (childs != null && childs.size() > 0){

                    for (Node child : childs) {

                        queue.offer(child);
                    }
                }
            }
        }

        return res;
    }
}
