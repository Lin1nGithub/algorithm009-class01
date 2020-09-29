import java.util.LinkedList;
import java.util.Queue;

/**
 * 117
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 填充每个节点的下一个右侧节点指针 II
 * @author linkuan
 * @version 1.0
 * @since 2020/9/28 15:27
 */
public class Connect117 {

    public Node connect(Node root) {

        if (root == null){

            return null;
        }

        connectTowNode(root.left, root.right);

        return root;
    }

    private void connectTowNode(Node q, Node p){

        if (null == q || p == null){

            return;
        }

        q.next = p;

        connectTowNode(q.left, q.right);

        connectTowNode(p.left, p.right);

        connectTowNode(q.right, p.left);
    }

    Queue<Node> queue = new LinkedList<>();

    public Node connectTow(Node root) {
        if (root == null){

            return null;
        }

        queue.offer(root);

        while (!queue.isEmpty()){

            int sz = queue.size();

            for (int i = 0; i < sz ;i ++){

                Node node = queue.poll();

                if (i < sz - 1){

                    node.next = queue.peek();
                }

                if (node.left != null){

                    queue.offer(node.left);
                }

                if (node.right != null){

                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
