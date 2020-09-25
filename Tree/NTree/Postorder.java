package NTree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 *  N叉树的后序遍历
 * @author linkuan
 * @version 1.0
 * @since 2020/9/25 12:04
 */
public class Postorder {

    List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {

        if (null == root){

            return res;
        }

        traverse(root);

        return res;
    }

    private void traverse(Node root){

        if (root == null){

            return;
        }

        for (Node child : root.children) {

            traverse(child);

        }

        res.add(root.val);
    }

}
