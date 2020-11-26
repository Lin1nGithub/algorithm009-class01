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

//    public int countNodes(TreeNode root) {
//
//        if (root == null){
//
//            return count;
//        }
//
//        q.offer(root);
//
//        while (!q.isEmpty()){
//
//            int sz = q.size();
//
//            for (int i = 0; i < sz; i++){
//
//                TreeNode node = q.poll();
//
//                if (node.left != null){
//
//                    q.offer(node.left);
//                }
//
//                if (node.right != null){
//
//                    q.offer(node.right);
//                }
//
//                count++;
//            }
//        }
//
//        return count;
//    }

    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int nodes = 0, h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << h-1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode left = root.left;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        TreeNode right = root.right;
        right.left = new TreeNode(6);
        CountNodes solution = new CountNodes();
        solution.countNodes(root);
    }
}
