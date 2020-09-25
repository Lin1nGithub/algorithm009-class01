package BuildTree;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 从中序与后序遍历序列构造二叉树
 * @author linkuan
 * @version 1.0
 * @since 2020/9/24 16:36
 */
public class BuildTree106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return build(inorder,0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd){

        if (inStart > inEnd){

            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int index = -1;

        for (int i = inStart; i <= inEnd; i++){

            if (postorder[postEnd] == inorder[i]){

                index = i;

                break;
            }
        }

        // 左子树长度
        int leftSize = index - inStart;

        root.left = build(inorder,inStart, index -1,postorder,postStart,postStart + leftSize - 1);

        root.right = build(inorder,index + 1, inEnd,postorder,postStart + leftSize, postEnd - 1);

        return root;
    }
}
