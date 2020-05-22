import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
 * @author linkuan
 * @version 1.0
 * @since 2020/5/22 17:07
 */
public class TwoSum {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) throws Exception{
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++){
            map.put(nums[i],i);
        }
        for (int i = 0; i< nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] { i , map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    class Solution {
        /**
         * 一次哈希表
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }

}
