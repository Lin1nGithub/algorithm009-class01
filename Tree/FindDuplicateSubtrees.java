import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 * 652
 * 寻找重复的子树
 * @author linkuan
 * @version 1.0
 * @since 2020/9/29 11:04
 */
public class FindDuplicateSubtrees {

    List<TreeNode> res = new LinkedList<>();

    Map<String,Integer> memo = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        traverse(root);

        return res;
    }

    private String traverse(TreeNode root){
        if (null == root) return "#";

        String left = traverse(root.left);

        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;

        Integer freq = memo.get(subTree) == null ? 0 : memo.get(subTree);

        if (freq == 1){

            res.add(root);
        }

        memo.put(subTree, freq + 1);

        return subTree;
    }
}
