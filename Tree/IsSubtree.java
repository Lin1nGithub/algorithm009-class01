/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * 572
 * 另一个树的子树
 * @author linkuan
 * @version 1.0
 * @since 2020/9/28 16:45
 */
public class IsSubtree {

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (t == null){

            return true;
        }

        if (s == null){

            return false;
        }

        // t是s的左子树的子树 || t是s的右子树的子树 || s和t是同一棵树）
//        return isSubtree(s.left,t) || isSubtree(s.right, t) || isSameTree(s,t);

        if (!isSameTree(s,t)){

            return isSubtree(s.left,t) || isSubtree(s.right,t);
        }

        return true;
    }


    private boolean isSameTree(TreeNode s, TreeNode t){

        if (s == null && t == null){

            return true;
        }

        if (s == null || t == null){

            return false;
        }

        if (s.val != t.val){

            return false;
        }

        return isSameTree(s.left,t.left) && isSameTree(s.right, t.right);
    }
}
