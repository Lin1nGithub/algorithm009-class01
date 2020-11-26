package TopK;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 剑指 Offer 40. 最小的k个数
 * @author linkuan
 * @version 1.0
 * @since 2020/11/9 13:53
 */
public class GetLeastNumbers {

    /**
     * 快排
     */
    public static class QuickSort{
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            // 最后一个参数表示我们要找的是下标为k-1的数
            return quickSearch(arr, 0, arr.length - 1, k - 1);
        }

        private int[] quickSearch(int[] nums, int lo, int hi, int k) {
            // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
            int j = partition(nums, lo, hi);
            if (j == k) {
                return Arrays.copyOf(nums, j + 1);
            }
            // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
            return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
        }

        // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
        private int partition(int[] nums, int lo, int hi) {
            int v = nums[lo];
            int i = lo, j = hi + 1;
            while (true) {
                while (++i <= hi && nums[i] < v);
                while (--j >= lo && nums[j] > v);
                if (i >= j) {
                    break;
                }
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
            nums[lo] = nums[j];
            nums[j] = v;
            return j;
        }
    }

    /**
     * 堆排序
     */
    public static class HeapSort{

        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr.length == 0 || k == 0) return new int[0];
            // 通过优先队列 默认小根堆 大根堆需要重写构造器
            Queue<Integer> pq = new PriorityQueue<>((v1,v2) -> v2 - v1);// 大根堆

//            Queue<Integer> pq = new PriorityQueue<>();

            for (int num: arr) {
                if (pq.size() < k) {
                    pq.offer(num);
                } else if (num < pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            }

            int[] res = new int[pq.size()];
            int index = 0;
            for (Integer num : pq) {
                res[index++] = num;
            }
            return res;
        }
    }

    /**
     * 计数排序
     */
    public static class CountingSort{

        public int[] getLeastNumbers(int[] arr, int k) {
            int[] counter = new int[10001];
//            for (int i = 0; i < arr.length; i++) {
//                counter[arr[i]]++;
//            }
            for (int num : arr) {
                counter[num]++;
            }
            int index = 0;
            int[] res = new int[k];
            for (int num = 0; num < counter.length; num++) {
                while (counter[num]-- > 0 && index < k){
                    res[index++] = num;
                }
                if (index == k){
                    break;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {

//        CountingSort sort = new CountingSort();
//        sort.getLeastNumbers(new int[]{4,5,1,6,2,7,3,8}, 4);
//        HeapSort sort = new HeapSort();
//        sort.getLeastNumbers(new int[]{4,5,1,6,2,7,3,8}, 4);
        QuickSort sort = new QuickSort();
        sort.getLeastNumbers(new int[]{4,5,1,6,2,7,3,8}, 4);
        GetLeastNumbers solution = new GetLeastNumbers();
        solution.sortArrayByParityII(new int[]{4,2,5,7});
    }

    public int[] sortArrayByParityII(int[] A) {
        int[] counter = new int[20001];
        for (int num : A) {
            counter[num]++;
        }
        int index = 0;
        int len = A.length;
        int[] res = new int[len];
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && index < len){
                res[index++] = num;
            }
            if (index == len){
                break;
            }
        }
        return res;
    }

}
