package TopK;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 215
 * @author linkuan
 * @version 1.0
 * @since 2020/11/9 11:04
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return 0;
        sort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    private void sort(int[] nums, int lo , int hi){
        if(lo > hi) return;
        int v = nums[lo];
        int left = lo, right = hi;
        while(left < right){
            while(left < right && nums[right] >= v){
                right--;
            }
            nums[left] = nums[right];
            while(right > left && nums[left] <= v){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = v;
        sort(nums, lo, left - 1);
        sort(nums, right + 1, hi);
    }

    public class HeapSort{
        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            // 使用一个含有 len 个元素的最小堆，默认是最小堆，可以不写 lambda 表达式：(a, b) -> a - b
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(len, (a, b) -> a - b);
            for (int i = 0; i < len; i++) {
                minHeap.add(nums[i]);
            }
            for (int i = 0; i < len - k; i++) {
                minHeap.poll();
            }
            return minHeap.peek();
        }
    }

    // （小数，基准元素，大数）。在区间中随机挑选一个元素作基准，将小于基准的元素放在基准之前，大于基准的元素放在基准之后，再分别对小数区与大数区进行排序。
    // 快速排序思路：
    // 1. 选取第一个数为基准
    // 2. 将比基准小的数交换到前面，比基准大的数交换到后面
    // 3. 对左右区间重复第二步，直到各区间只有一个数
    /**
     * 快排
     * @param nums
     * @param lo
     * @param hi
     */
    private void quickSort(int[] nums, int lo, int hi){
        if(lo > hi) return;
        //待排序的第一个元素作为基准值
        int v = nums[lo];
        int left = lo, right = hi;
        while (left < right) {
            while (right > left && nums[right] >= v) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }

            //找到这种元素将arr[right]放入arr[left]中
            nums[left] = nums[right];

            while (left < right && nums[left] <= v){
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }

            //找到这种元素将arr[left]放入arr[right]中
            nums[right] = nums[left];
        }

        //基准值归位
        nums[left] = v;

        //对基准值左边的元素进行递归排序
        quickSort(nums, lo, left - 1);

        //对基准值右边的元素进行递归排序。
        quickSort(nums, right + 1, hi);
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        findKthLargest.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        findKthLargest.quickSort(nums, 0, nums.length - 1);
        findKthLargest.generateParenthesis(3);
    }

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        parenthesis(new StringBuffer(), n, n);
        return res;
    }

    private void parenthesis(StringBuffer path, int left, int right){
        if(left == 0 && right == 0){
            res.add(path.toString());
            return;
        }
        if(left > right){
            return;
        }
        if (left > 0){
            path.append("(");
            parenthesis(path, left - 1, right);
            path.deleteCharAt(path.length() - 1);
        }
        if (right > 0){
            path.append(")");
            parenthesis(path, left, right - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
