import java.util.*;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 * 316
 * 去除重复字母
 * @author linkuan
 * @version 1.0
 * @since 2020/11/16 17:04
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        // 记录字符出现的最后位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        boolean[] visited = new boolean[26];// 字符是否被放入dq中
        Deque<Character> dq = new LinkedList<>();// 存放最后输出的字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果栈中已经存在，就跳过
            if (visited[c - 'a']){
                continue;
            }
            // 1.在栈非空，2.当前元素字典序 < 栈顶元素，3.栈顶元素在以后还会出现，弹出栈元素
            while (!dq.isEmpty() && c < dq.peekLast() && lastIndex[dq.peekLast() - 'a'] > i){
                char top = dq.pollLast();
                visited[top - 'a'] = false;
            }
            dq.offerLast(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()){
            sb.append(dq.pollFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();
        solution.removeDuplicateLetters("bcabc");

        solution.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2});

        solution.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});

        solution.singleNumber(new int[]{2,2,1});

        int[][] matrix =new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
    }

    public boolean containsDuplicate(int[] nums) {
        quickSort(0, nums.length - 1, nums);
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }

    private void quickSort(int lo, int hi, int nums[]){
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
        quickSort(lo, left - 1, nums);
        quickSort(right + 1, hi, nums);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] counter = new char[26];
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                counter[chars[i] - 'a'] ++;
            }
            String key = String.valueOf(counter);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public int removeDuplicates(int[] nums) {
        int fast = 0, slow = 0;
        while(fast < nums.length){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }

    public String removeKdigits(String num, int k) {
        if (num.length() < k) return "0";
        Deque<Character> dp = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !dp.isEmpty() && dp.peekLast() > num.charAt(i)){
                dp.pollLast();
                k--;
            }
            if (!dp.isEmpty() || num.charAt(i) != '0'){
                dp.offer(num.charAt(i));
            }
        }
        while (k > 0 && !dp.isEmpty()){
            dp.pollLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!dp.isEmpty()){
            sb.append(dp.pollFirst());
        }
        return sb.length() == 0 ? "0" :
                sb.toString();
    }
}
