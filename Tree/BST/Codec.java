package BST;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-bst/
 * 序列化和反序列化二叉搜索树
 * 449
 * @author linkuan
 * @version 1.0
 * @since 2020/9/28 17:42
 */
public class Codec {

    // todo
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        traverse(root, sb);

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private void traverse(TreeNode root,StringBuilder sb){

        if (null == root){

            return;
        }

        traverse(root.left, sb);

        traverse(root.right, sb);

        // 后序遍历
        sb.append(root.val);

        sb.append(" ");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.length() == 0){

            return null;
        }

        String[] split = data.split("\\s+");

        int[] nums = new int[split.length];

        for (int i = 0; i < split.length; i++) {

            nums[i] = Integer.valueOf(split[i]);
        }

        return build(nums,0, nums.length - 1);
    }

    private TreeNode build(int nums[], int low, int high){

        if (low > high){

            return null;
        }

        int index = -1;

        int rootValue = Integer.MIN_VALUE;

        for (int i = low; i <= high ; i++){

            if (nums[i] > rootValue){

                index = i;

                rootValue = nums[i];
            }
        }

        TreeNode root = new TreeNode(rootValue);

        root.left = build(nums, low, index - 1);

        root.right = build(nums, index + 1, high);

        return root;
    }
}
