import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * 35
 * 搜索插入位置
 *
 * @author linkuan
 * @version 1.0
 * @since 2020/10/29 17:19
 */
public class SearchInsert {

    /**
     * 二分查找条件
     * 1.数据有序
     * 2.有区间
     * 3.存在索引
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return left;
    }


    class Solution{

        public int searchInsert(int[] nums, int target) {

            int left = 0;

            while (left < nums.length){

                if (nums[left] >= target){

                    return left;
                }

                left++;
            }

            return left;
        }
    }


    public static void main(String[] args) {

        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(new int[]{1,3,5,6}, 2));
    }
}
