package BST;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 108
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 将有序数组转换为二叉搜索树
 * @author linkuan
 * @version 1.0
 * @since 2020/9/20 12:46 下午
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {

        return traverse(nums, 0 , nums.length - 1);
    }

    private TreeNode traverse(int nums[], int low, int high){

        if (low > high){

            return null;
        }

        int mid = low + (high - low) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = traverse(nums, low, mid - 1);

        root.right = traverse(nums,mid + 1, high);

        return root;
    }
}
