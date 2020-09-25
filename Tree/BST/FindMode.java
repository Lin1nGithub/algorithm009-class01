package BST;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * 二叉搜索树中的众数
 * @author linkuan
 * @version 1.0
 * @since 2020/9/24 10:45
 */
public class FindMode {

    int count = Integer.MIN_VALUE;

    int maxCount = Integer.MIN_VALUE;

    List<Integer> mode = new ArrayList<>();

    int current = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {

        traverse(root);

        int[] res = new int[mode.size()];

        for (int i = 0 ; i < mode.size() ; i++){

            res[i] = mode.get(i);
        }

        return res;
    }

    private void traverse(TreeNode root){
        if (null == root){

            return;
        }

        traverse(root.left);

        if (root.val == current){

            count++;

        }else{

            count = 1;

            current = root.val;
        }

        if (count > maxCount){

            maxCount = count;

            mode.clear();

            mode.add(root.val);

        }else if (count == maxCount){

            mode.add(root.val);
        }

        traverse(root.right);
    }

    Queue<TreeNode> queue = new LinkedList<>();

    public int minDepth(TreeNode root) {

        if (root == null){

            return 0;
        }

        queue.offer(root);

        int step = 1;

        while (!queue.isEmpty()){

            int sz = queue.size();

            for (int i = 0; i < sz ; i++){

                TreeNode node = queue.poll();

                if (node.left == null && node.right == null){

                    return step;
                }

                if (node.left != null){

                    queue.offer(node.left);
                }

                if (node.right != null){

                    queue.offer(node.right);
                }
            }

            step++;
        }

        return step;
    }

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null){

            return false;
        }

        if (root.left == null && root.right == null){

            if (root.val == sum){

                return true;
            }
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0){

            return null;
        }

        return traverse(nums,0 , nums.length - 1);
    }

    private TreeNode traverse(int[] nums, int left, int right){

        if (left > right){

            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = traverse(nums, left, mid - 1);

        root.right = traverse(nums, mid + 1, right);

        return root;
    }
}
