import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 93
 * 复原IP地址
 * @author linkuan
 * @version 1.0
 * @since 2020/11/10 19:54
 */
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, 4, path, res);
        return res;
    }

    // 需要一个变量记录剩余多少段还没被分割
    private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }

            if (residue * 3 < len - i) {
                continue;
            }

            if (judgeIpSegment(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);

                dfs(s, len, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }

    private void quickSort(int[] nums, int lo, int hi){
        if (lo > hi) return;

        int left = lo, right = hi;

        int v = nums[left];

        while (left < right){

            while (right > left && nums[right] >= v){
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

        RestoreIpAddresses solution = new RestoreIpAddresses();
        int[] nums =  new int[]{16,20,5,7,2,1,0};
        solution.quickSort(nums, 0, nums.length - 1);
        System.out.println(nums);
    }

}
