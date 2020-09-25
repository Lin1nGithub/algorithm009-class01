package BuildTree;

/**
 * 105
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 从前序与中序遍历序列构造二叉树
 * @author linkuan
 * @version 1.0
 * @since 2020/9/24 15:45
 *
 * 东哥手把手帮你刷通二叉树|第二期
 * https://mp.weixin.qq.com/s/OlpaDhPDTJlQ5MJ8tsARlA
 *
 */
public class BuildTree105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder,0,preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd){

        if (inStart > inEnd){

            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int index = -1;

        // 通过遍历获取根节点在 中序遍历的坐标
        for (int i = inStart; i <= inEnd; i++){

            if (preorder[preStart] == inorder[i]){

                index = i;

                break;
            }
        }

        // 中序遍历的左右子树的下标 可以通过 index来确定

        // 通过中序遍历根节点的坐标确定 左子树的长度
        int leftSize = index - inStart;

        // 通过左子树的长度确定 先序遍历中 左子树和右子树的下标

        root.left = build(preorder,preStart + 1,preStart + leftSize,inorder,inStart,index - 1);

        root.right = build(preorder,preStart + leftSize + 1,preEnd,inorder,index + 1,inEnd);

        return root;
    }

}
