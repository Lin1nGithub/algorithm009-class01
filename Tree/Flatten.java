import java.util.LinkedList;
import java.util.List;

/**
 * 114
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 二叉树展开为链表
 * @author linkuan
 * @version 1.0
 * @since 2020/9/11 9:01 下午
 * 东哥手把手带你套框架刷通二叉树|第一期
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487126&idx=1&sn=4de13e66397bc35970963c5a1330ce18&chksm=9bd7f09eaca0798853c41fba05ad5fa958b31054eba18b69c785ae92f4bd8e4cc7a2179d7838&scene=21#wechat_redirect
 *
 */
public class Flatten {

    public void flatten(TreeNode root) {

        if (root == null){

            return;
        }

        flatten(root.left);

        flatten(root.right);

        // #### 后序遍历
        // 现在左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 1.当前的左节点置空 并且将左节点放在右节点上
        root.left = null;

        root.right = left;

        // 2.将之前的右节点接到现在右节点的后面
        TreeNode p = root;
        // 遍历到当前右节点的底端
        while (p.right != null){
            p = p.right;
        }
        p.right = right;
    }

}
