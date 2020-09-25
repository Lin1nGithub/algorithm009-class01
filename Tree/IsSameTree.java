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

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return build(inorder, 0, inorder.length - 1, postorder, 0 , postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){

        if (inStart > inEnd){
            return null;
        }

        // 根据后序遍历 构造根节点
        TreeNode root = new TreeNode(postorder[postEnd]);

        int index = -1;

        // 获取根节点在中序遍历中的坐标
        for (int i = inStart; i <= inEnd; i++){

            if (postorder[postEnd] == inorder[i]){

                index = i;

                break;
            }
        }

        int leftSize = index - inStart;

        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);

        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
}
