package BinarySearch;

/**
 * 二分查找
 * @author linkuan
 * @version 1.0
 * @since 2020/9/16 9:20 下午
 */
public class BinarySearch {

    /**
     * 有序数组中没有重复的数组解法
     * @param nums
     * @param target
     * @return
     */
    int binarySearch(int nums[], int target){

        int left = 0;

        int right = nums.length - 1;// 最后一个元素的索引

        while (left <= right){

            // 计算 mid 时需要防止溢出，
            // 代码中left + (right - left) / 2就和(left + right) / 2的结果相同，但是有效防止了left和right太大直接相加导致溢出。
            int mid = left + (right - left) / 2;

            // 不要出现 else，而是把所有情况用 else if 写清楚，这样可以清楚地展现所有细节。
            if(nums[mid] < target){

                left = mid + 1;
            }else if(nums[mid] > target){

                right = mid - 1;
            }else if (target == nums[mid]){

                return mid;
            }
        }

        return -1;
    }

    /**
     * 寻找左侧边界的二分搜索
     * @param nums
     * @param target
     * @return
     */
    int left_bound(int nums[], int target){
        int left = 0;

        int right = nums.length - 1;

        while (left <= right){

            int mid = left + (right - left) / 2;

            if (nums[mid] < target){

                left = mid + 1;
            }else if(nums[mid] > target){

                right = mid - 1;
            // 缩小「搜索区间」的下界right，使得区间不断向左收缩，达到锁定左侧边界的目的。
            }else if(nums[mid] ==  target){

                right = mid - 1;
            }
        }

        // 数组越界 数组长度 nmus.lenght - 1（ 条件设置成 left > num.lenght - 1同理？
        if (left >= nums.length || nums[left] != target){

            return -1;
        }

        return left;
    }

    /**
     * 寻找右侧边界的二分查找
     * @param nums
     * @param target
     * @return
     */
    int right_bound(int nums[], int target){

        int left = 0;

        int right = nums.length - 1;

        while (left <= right){

            int mid = left + (right - left) / 2;

            if (nums[mid] < target){

                left = mid + 1;
            }else if(nums[mid] > target){

                right = mid - 1;

            // 增大「搜索区间」的下界left，使得区间不断向右收缩，达到锁定右侧边界的目的。
            }else if(nums[mid] == target){

                left = mid + 1;
            }
        }

        //  数组越界
        if (right < 0 || nums[right] != target){

            return -1;
        }

        return right;
    }


}
