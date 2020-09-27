package BST;

/**
 * 256
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 二叉树的最近公共祖先
 * @author linkuan
 * @version 1.0
 * @since 2020/9/16 10:12 下午
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 如果root为空，肯定得返回null。
        if (root == null){

            return null;
        }

        // root本身就是p或者q，比如说root就是p节点吧，如果q存在于以root为根的树中，显然root就是最近公共祖先；即使q不存在于以root为根的树中，按照情况 3 的定义，也应该返回root节点。
        if (root == q || root == p){

            return root;
        }

        // 有值代表 p或者q存在于该root下
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果p和q都在以root为根的树中，那么left和right一定分别是p和q（从 base case 看出来的）
        if (left != null && right != null){

            return root;
        }

        // 如果p和q都不在以root为根的树中，直接返回null。
        if (left == null && right == null){

            return null;
        }

        // 如果p和q只有一个存在于root为根的树中，函数返回该节点。
        return left == null ? right : left;
    }


    private int binarySearch(int nums[] ,int target){
        if (nums.length == 0){

            return -1;
        }

        int left = 0;

        int right = nums.length - 1;

        while (left <= right){

            int mid = left + (right - left) / 2;

            if (nums[mid] < target){

                left = mid + 1;
            }else if (nums[mid] > target){

                right = mid - 1;
            }else if (nums[mid] == target){

                return mid;
            }
        }

        return -1;
    }

    private int lef_bond(int num[] ,int target){

        if (num.length == 0){

            return -1;
        }

        int left = 0;

        int right = num.length - 1;

        while (left <= right){

            int mid = left + (right - left) / 2;

            if (num[mid] < target){

                left = mid + 1;
            }else if (num[mid] > target){

                right = mid - 1;
            }else if (num[mid] == target){

                right = mid - 1;
            }
        }

        if (left > num.length || num[left] != target){

            return -1;
        }

        return left;
    }

    private int right_bond(int num[] ,int target){

        if (num.length == 0){

            return -1;
        }

        int left = 0;

        int right = num.length - 1;

        while (left <= right){

            int mid = left + (right - left) / 2;

            if (num[mid] < target){

                left = mid + 1;
            }else if (num[mid] > target){

                right = mid - 1;
            }else if (num[mid] == target){

                left = mid + 1;
            }
        }

        if (right < 0 || num[right] != target){

            return -1;
        }

        return right;
    }
}
