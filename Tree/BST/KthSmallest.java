package BST;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中第K小的元素
 * 230
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * @author linkuan
 * @version 1.0
 * @since 2020/11/1 20:23
 */
public class KthSmallest {

    int rank = 0;

    int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, Integer k){
        if (root == null) return;
        traverse(root.left, k);
        if (k == ++rank){
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
