import java.util.*;

/**
 * 分治
 * @author linkuan
 * @version 1.0
 * @since 2020/11/26 14:41
 */
public class DivideAndConquer {

    /**
     * 241
     * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
     * 为运算表达式设计优先级
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*'){
                // 分
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                // 治
                for (Integer a : left) {
                    for (Integer b : right) {
                        if (c == '-'){
                            res.add(a - b);
                        }else if (c == '+'){
                            res.add(a + b);
                        }else{
                            res.add(a * b);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()){
            res.add(Integer.valueOf(input));
        }
        return res;
    }


    /**
     * 数组中的第K个最大元素
     * 215
     * @return
     */
    static class FindKthLargest{

        private static Random random = new Random(System.currentTimeMillis());

        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            int left = 0, right = len - 1;
            int target = len - k;
            while (true){
                int index = partition(nums, left, right);
                if (index == target){

                    return nums[index];
                }else if (index > target){

                    right = index - 1;
                }else if (index < target){

                    left = index + 1;
                }
            }
        }

        private int partition(int[] nums, int lo, int hi){
            // 在区间随机选择一个元素作为标定点
            if (hi > lo) {
                int randomIndex = lo + 1 + random.nextInt(hi - lo);
                swap(nums, lo, randomIndex);
            }
            int v = nums[lo];
            int left = lo, right = hi;
            while (left < right){
                while (left < right && nums[right] >= v){
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && nums[left] <= v){
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = v;
            return right;
        }

        private void swap(int[] nums, int index1, int index2){
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }

    /**
     * 剑指 Offer 40. 最小的k个数
     * @return
     */
    static class GetLeastNumbers{

        public int[] getLeastNumbers(int[] arr, int k) {

            return quickSearch(arr, 0, arr.length - 1, k - 1);
        }

        private int[] quickSearch(int[] nums, int lo, int hi, int k){
            // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
            int right = partition(nums, lo, hi);
            if (right == k){
                return Arrays.copyOf(nums, k + 1);
            }
            return right > k ? quickSearch(nums, lo, right - 1, k) : quickSearch(nums, right + 1, hi, k);
        }

        // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
        private int partition(int[] nums, int lo, int hi) {
            int v = nums[lo];
            int left = lo, right = hi;
            while(left < right){
                while(left < right && nums[right] >= v){
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && nums[left] <= v){
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = v;
            return right;
        }
    }


    public static void main(String[] args) {
        DivideAndConquer solution = new DivideAndConquer();
        List<Integer> list = solution.diffWaysToCompute("2-1-1");
        System.out.println(list);

        GetLeastNumbers getLeastNumbers =new GetLeastNumbers();
        int[] leastNumbers = getLeastNumbers.getLeastNumbers(new int[]{0,0,0,2,0,5}, 0);
        System.out.println(leastNumbers);
    }
}
