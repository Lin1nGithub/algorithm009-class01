/**
 *
 * https://leetcode-cn.com/problems/same-tree/
 * 相同的树
 * @author linkuan
 * @version 1.0
 * @since 2020/9/22 17:32
 */
public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null){

            return true;
        }

        if(p == null || q == null){

            return false;
        }

        if(p.val != q.val){

            return false;
        }

        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }

}
