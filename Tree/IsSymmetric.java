import java.util.*;

/**
 * 是否对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * @author linkuan
 * @version 1.0
 * @since 2020/9/6 3:34 下午
 */
public class IsSymmetric {

    Queue<TreeNode> q = new LinkedList<>();

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v){
        q.offer(u);
        q.offer(v);

        while (!q.isEmpty()){
             u = q.poll();
             v = q.poll();
             if (u == null && v == null){
                 continue;
             }
             if (u == null || v == null){
                 return false;
             }
             if (u.val != v.val){
                 return false;
             }

             q.offer(u.left);
             q.offer(v.right);

             q.offer(u.right);
             q.offer(v.left);
        }

        return true;
    }

    class Solution{

        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        public boolean check(TreeNode q, TreeNode p){
            if (null == q && p == null){
                return true;
            }
            if (q == null || p == null){
                return false;
            }
            if (q.val != p.val){
                return false;
            }

            return check(q.left, p.right) && check(q.right, p.left);
        }
    }

    public TreeNode invertTree(TreeNode root) {

        if(root == null){

            return root;
        }

        TreeNode temp = root.left;

        root.left = root.right;

        root.right = temp;

        invertTree(root.left);

        invertTree(root.right);

        return root;
    }


}
