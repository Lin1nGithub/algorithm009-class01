import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 二叉树的所有路径
 * @author linkuan
 * @version 1.0
 * @since 2020/9/12 3:11 下午
 */
public class BinaryTreePaths {

    List<String> res = new ArrayList<>();

    String symbol = "->";

    public List<String> binaryTreePaths(TreeNode root) {

        StringBuffer path = new StringBuffer();

        backTrack(root, path);

        return res;
    }

    private void backTrack(TreeNode root,StringBuffer path){

        if (root == null){
            return;
        }

        path.append(root.val);

        if (root.left == null && root.right == null){

            res.add(path.toString());

            return;
        }

        backTrack(root.left, new StringBuffer(path).append(symbol));

        backTrack(root.right, new StringBuffer(path).append(symbol));
    }

}
