import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * 二叉树的右视图
 * @author linkuan
 * @version 1.0
 * @since 2020/9/14 10:09 下午
 */
public class RightSideView {

    List<Integer> res = new ArrayList<>();

    Queue<TreeNode> deque = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {

        if (null == root){

            return res;
        }

        deque.offer(root);

        while (!deque.isEmpty()){

            int sz = deque.size();

            for (int i = 0 ; i < sz; i++){

                TreeNode poll = deque.poll();

                if (poll.left != null){

                    deque.offer(poll.left);
                }

                if (poll.right != null){

                    deque.offer(poll.right);
                }

                if (i == sz - 1){
                    res.add(poll.val);
                }
            }
        }

        return res;
    }
}
