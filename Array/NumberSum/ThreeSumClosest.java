package NumberSum;

/**
 * 最接近的三数之和
 * 16
 * @author linkuan
 * @version 1.0
 * @since 2020/11/27 13:47
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        quickSort(nums, 0, nums.length - 1);

        int res = nums[0] + nums[1] + nums[2];

        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1, j = nums.length - 1;

            while (i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(Math.abs(sum - target) < Math.abs(res - target))
                    res = sum;

                if (sum > target){
                    while (i < j && nums[j] == nums[--j]);
                }else if (sum < target){
                    while (i < j && nums[i] == nums[++i]);
                }else {
                    return target;
                }
            }
        }

        return res;
    }

    private void quickSort(int[] nums, int lo, int hi){
        if (lo > hi) return;
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
        quickSort(nums, lo, left - 1);
        quickSort(nums, right + 1, hi);
    }

    public static void main(String[] args) {

        ThreeSumClosest solution = new ThreeSumClosest();
        int i = solution.threeSumClosest(new int[]{-100,-98,-2,-1}, -200);
    }
}
