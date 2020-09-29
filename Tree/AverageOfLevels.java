import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * 637
 * 二叉树的层平均值
 * @author linkuan
 * @version 1.0
 * @since 2020/9/29 10:41
 */
public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null){

            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Double>  res = new ArrayList<>();

        while (!queue.isEmpty()){

            int sz = queue.size();

            double sum = 0;

            for (int i = 0; i < sz; i++) {

                TreeNode node = queue.poll();

                sum += node.val;

                if (node.left != null){

                    queue.offer(node.left);
                }

                if (node.right != null){

                    queue.offer(node.right);
                }
            }

            res.add(sum / sz);
        }

        return res;
    }
}
