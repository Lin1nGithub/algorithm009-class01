package NTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * N叉树的前序遍历
 * 589
 * @author linkuan
 * @version 1.0
 * @since 2020/9/25 11:54
 */
public class Preorder {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {

        if (root == null){

            return res;
        }


        traverse(root);

        return res;
    }

    private void traverse(Node root){

        if (root == null){

            return;
        }

        res.add(root.val);

        for (Node child : root.children) {

            traverse(child);
        }
    }
}
