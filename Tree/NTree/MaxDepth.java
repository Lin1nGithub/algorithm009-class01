package NTree;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * N叉树的最大深度
 * 559
 * @author linkuan
 * @version 1.0
 * @since 2020/9/25 15:58
 */
public class MaxDepth {

    public int maxDepth(Node root) {

        if (root == null){

            return 0;
        }

        int depth = 0;

        for (Node child : root.children) {

            depth = Math.max(maxDepth(child), depth);
        }

        return depth + 1;
    }
}
