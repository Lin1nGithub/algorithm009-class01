package TopK;

import java.util.*;

/**
 * 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @author linkuan
 * @version 1.0
 * @since 2020/11/9 11:02
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        // 最小堆
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> counter.get(n1) - counter.get(n2));

        for (int n: counter.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        int[] res = new int[heap.size()];
        int idx = 0;
        for (Integer num : heap) {
            res[idx++]  = num;
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        topKFrequent.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
}
