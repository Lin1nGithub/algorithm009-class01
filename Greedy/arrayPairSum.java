import java.util.Arrays;

/**
 * @author linkuan
 * @version 1.0
 * @since 2021/2/16 17:53
 */
public class arrayPairSum {

    public int arrayPairSum(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i += 2){
            ans += nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        arrayPairSum arrayPairSum = new arrayPairSum();
        arrayPairSum.arrayPairSum(new int[]{});
    }
}
