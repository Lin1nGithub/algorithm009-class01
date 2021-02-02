package SlidingWindow;

import BST.ListNode;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * 滑动窗口最大值
 * 239
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * @author linkuan
 * @version 1.0
 * @since 2020/11/10 10:13
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1){
                window.push(nums[i]);
            }else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public class MonotonicQueue{

        private LinkedList<Integer> q = new LinkedList<>();

        private void push(int n){
            while (!q.isEmpty() && q.getLast() < n){
                q.pollLast();
            }
            q.addLast(n);
        }

        private int max(){

            return q.getFirst();
        }

        private void pop(int n){
            if (n == q.getFirst()){
                q.pollFirst();
            }
        }
    }

        /*
      思路： 遍历数组 L R 为滑窗左右边界 只增不减
            双向队列保存当前窗口中最大的值的数组下标 双向队列中的数从大到小排序，
            新进来的数如果大于等于队列中的数 则将这些数弹出 再添加
            当R-L+1=k 时 滑窗大小确定 每次R前进一步L也前进一步 保证此时滑窗中最大值的
            数组下标在[L，R]中，并将当前最大值记录
      举例： nums[1，3，-1，-3，5，3，6，7] k=3
         1：L=0，R=0，队列【0】 R-L+1 < k
                队列代表值【1】
         2: L=0,R=1, 队列【1】 R-L+1 < k
                队列代表值【3】
         解释：当前数为3 队列中的数为【1】 要保证队列中的数从大到小 弹出1 加入3
              但队列中保存的是值对应的数组下标 所以队列为【1】 窗口长度为2 不添加记录
         3: L=0,R=2, 队列【1，2】 R-L+1 = k ,result={3}
                队列代表值【3，-1】
         解释：当前数为-1 队列中的数为【3】 比队列尾值小 直接加入 队列为【3，-1】
              窗口长度为3 添加记录记录为队首元素对应的值 result[0]=3
         4: L=1,R=3, 队列【1，2，3】 R-L+1 = k ,result={3，3}
                队列代表值【3，-1,-3】
         解释：当前数为-3 队列中的数为【3，-1】 比队列尾值小 直接加入 队列为【3，-1，-3】
              窗口长度为4 要保证窗口大小为3 L+1=1 此时队首元素下标为1 没有失效
              添加记录记录为队首元素对应的值 result[1]=3
         5: L=2,R=4, 队列【4】 R-L+1 = k ,result={3，3，5}
                队列代表值【5】
         解释：当前数为5 队列中的数为【3，-1，-3】 保证从大到小 依次弹出添加 队列为【5】
              窗口长度为4 要保证窗口大小为3 L+1=2 此时队首元素下标为4 没有失效
              添加记录记录为队首元素对应的值 result[2]=5
        依次类推 如果队首元素小于L说明此时值失效 需要弹出
    */
    public int[] maxSlidingWindoW(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 遍历nums数组
        for(int i = 0; i < nums.length; i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.getFirst() <= i - k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i + 1 >= k){
                result[i + 1 - k] = nums[queue.getFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow solution = new MaxSlidingWindow();
        solution.maxSlidingWindow(new int[]{1,-1,3,-3,5,3,6,7}, 3);

        Vector<String> list = new Vector<>();
        try {
            CountDownLatch countDownLatch = new CountDownLatch(10);
            for (int i = 0; i < 10; i++){
                new Thread(() -> {
                    list.add(Thread.currentThread().getName());
                    countDownLatch.countDown();
//                    System.out.println(countDownLatch.getCount());
                }).start();
            }
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums,0,k);
        reverse(nums,k,nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
