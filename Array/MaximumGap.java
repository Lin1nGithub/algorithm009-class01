/**
 * 164
 * 最大间距
 * @author linkuan
 * @version 1.0
 * @since 2020/11/26 19:00
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        quickSort(0, nums.length - 1, nums);
        int right = 1, left = 0, res = Integer.MIN_VALUE;
        while (right < nums.length){
            int c = nums[right];
            right++;

            int d = nums[left];
            res = Math.max(res, c - d);
            left++;
        }
        return res;
    }

    public void quickSort(int lo, int hi, int[] nums){
        if(lo > hi){
            return;
        }
        int v = nums[lo];
        int left = lo, right = hi;
        while(left < right){
            while(right > left && nums[right] >= v){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] <= v){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = v;
        quickSort(lo, left - 1, nums);
        quickSort(left + 1, hi, nums);
    }

    public static void main(String[] args) {

        MaximumGap solution = new MaximumGap();
        solution.maximumGap(new int[]{3,6,9,1});
    }
}
