package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 二叉树的最小深度
 * @author linkuan
 * @version 1.0
 * @since 2020/9/3 9:43 下午
 *
 */
public class MinDepth {

    Queue<TreeNode> q = new LinkedList<>();

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        q.offer(root);
        int step = 1;
        while (!q.isEmpty()){
            int sz = q.size();
            for (int i = 0 ; i < sz ; i++){
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null){
                    return step;
                }
                if (cur.left != null){
                    q.offer(cur.left);
                }
                if (cur.right != null){
                    q.offer(cur.right);
                }
            }
            step++;
        }
        return step;
    }

    // 计算从起点 start 到终点 target 的最近距离
    int BFS(TreeNode start, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>(); // 核心数据结构
        Set<TreeNode> visited = new HashSet<>(); // 避免走回头路

        q.offer(start); // 将起点加入队列
        visited.add(start);
        int step = 0; // 记录扩散的步数

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 划重点：这里判断是否到达终点 */
                if (cur == target)
                    return step;
                /* 将 cur 的相邻节点加入队列 */
                if (cur.left != null){
                    if (!visited.contains(cur.left)) {
                        q.offer(cur.left);
                        visited.add(cur.left);
                    }
                }
                if (cur.right != null){
                    if (!visited.contains(cur.right)) {
                        q.offer(cur.right);
                        visited.add(cur.right);
                    }
                }

                // 队列q就不说了，BFS 的核心数据结构；cur.adj()泛指cur相邻的节点，比如说二维数组中，cur上下左右四面的位置就是相邻节点；
                // visited的主要作用是防止走回头路，大部分时候都是必须的，但是像一般的二叉树结构，
                // 没有子节点到父节点的指针，不会走回头路就不需要visited。
            }

            /* 划重点：更新步数在这里 */
            step++;
        }

        return step;
    }
}


