package BST;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/9/16 10:12 下午
 */
public class LowestCommonAncestor {
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
