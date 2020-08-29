import java.util.Arrays;
import java.util.LinkedList;

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
        sb.append("[");
        doSerialize(root, sb);
        sb.subSequence(0, sb.length() - 1); // 去掉最后一个逗号
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (null == data || data.length() == 0){
            return null;
        }
        data = data.replace("[","");
        data = data.replace("]","");
        String[] array = data.split(",");
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(array));

        return doDeserialize(nodes);
    }

    void doSerialize(TreeNode node,StringBuffer sb){

        if (node == null){

            sb.append(NULL).append(SEP);

            return;
        }

        sb.append(node.val).append(SEP);

        doSerialize(node.left,sb);

        doSerialize(node.right,sb);
    }

    TreeNode doDeserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()){
            return null;
        }
        String val = nodes.removeFirst();
        if (val.equals(NULL)){
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(val));

        root.left = doDeserialize(nodes);

        root.right = doDeserialize(nodes);

        return root;
    }

}
