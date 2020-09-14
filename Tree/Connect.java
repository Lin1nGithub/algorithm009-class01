import java.util.*;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * 填充每个节点的下一个右侧节点指针
 * @author linkuan
 * @version 1.0
 * @since 2020/9/13 4:58 下午
 */

public class Connect {

    Queue<Node> q = new LinkedList<>();

    public Node connect(Node root) {
        if (root == null){
            return root;
        }

        q.offer(root);

        while (!q.isEmpty()){

            int sz = q.size();

            for (int i = 0; i < sz; i++){

                Node node = q.poll();

                if (i < sz - 1){
                    node.next = q.peek();
                }

                if (null != node.left){

                    q.offer(node.left);
                }
                if (null != node.right){

                    q.offer(node.right);
                }
            }

        }

        return root;
    }

}
