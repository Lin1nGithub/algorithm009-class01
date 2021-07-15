import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/12/21 21:03
 */
public class ClimbStairs {

    public int climbStairs(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 1;

        dp[1] = 1;

        for(int i = 2; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public void quickSort(int[] nums, int lo, int hi){
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
        quickSort(nums, lo, left -1);
        quickSort(nums, right + 1, hi);
    }

    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int count = left[ratings.length - 1];
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }
            count += Math.max(left[i], right[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        ClimbStairs solution = new ClimbStairs();
        System.out.println(solution.candy(new int[]{0,1,2,5,3,2,7}));

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = listNode.next = new ListNode(2);
        ListNode listNode2 = listNode1.next = new ListNode(3);
        ListNode listNode3 = listNode2.next = new ListNode(4);
        ListNode listNode4 = listNode3.next = new ListNode(5);
        reverseList(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur = null, pre = head;
        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }
}
