/**
 * 二叉树的序列化和反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author linkuan
 * @version 1.0
 * @since 2020/8/29 16:26
 */
public class Codec {

    String SEP = ",";

    String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        traverse(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        return null;
    }

    void traverse(TreeNode node,StringBuffer sb){

        if (node == null){

            sb.append(NULL);
        }

        sb.append(node.val).append(SEP);

        traverse(node.left,sb);


        traverse(node.right,sb);

    }
}
