/**
 * 654
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * 最大二叉树
 * @author linkuan
 * @version 1.0
 * @since 2020/9/24 15:18
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return build(nums, 0, nums.length - 1);
    }

    /* 将 nums[lo..hi] 构造成符合条件的树，返回根节点 */
    private TreeNode build(int[] nums, int low, int high){

        if (low > high){

            return null;
        }

        int index = -1;

        int maxValue = Integer.MIN_VALUE;

        // 遍历数组获取最大值
        for (int i = low; i <= high; i++){

            if (nums[i] > maxValue){

                maxValue = nums[i];

                index = i;
            }
        }

        TreeNode root = new TreeNode(maxValue);

        // 递归调用构造左右子树
        root.left = build(nums, low, index - 1);

        root.right = build(nums, index + 1, high);

        return root;
    }

}
