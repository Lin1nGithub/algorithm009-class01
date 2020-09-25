import java.util.*;

/**
 * 116
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * 填充每个节点的下一个右侧节点指针
 * @author linkuan
 * @version 1.0
 * @since 2020/9/13 4:58 下午
 * 东哥手把手带你套框架刷通二叉树|第一期
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487126&idx=1&sn=4de13e66397bc35970963c5a1330ce18&chksm=9bd7f09eaca0798853c41fba05ad5fa958b31054eba18b69c785ae92f4bd8e4cc7a2179d7838&scene=21#wechat_redirect
 */

public class Connect {

    // 无法解决两个非同父节点的两个子节点
    class Solution{

        Node connect(Node root) {
            if (root == null || root.left == null) {
                return root;
            }

            root.left.next = root.right;

            connect(root.left);
            connect(root.right);

            return root;
        }
    }

    public Node connect(Node root) {

        if(root == null){

            return null;
        }

        connectTowNode(root.left, root.right);

        return root;
    }


    // 定义：输入两个节点，将它俩连接起来
    private void connectTowNode(Node node1, Node node2){

        if (node1 == null || node2 == null){

            return;
        }

        node1.next = node2;

        // 连接相同父节点的两个子节点
        connectTowNode(node1.left, node1.right);
        connectTowNode(node2.left, node2.right);

        // 连接跨越父节点的两个子节点
        connectTowNode(node1.right, node2.left);
    }

}
