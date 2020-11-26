import java.util.*;

/**
 * 49
 * 字母异位词分组
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @author linkuan
 * @version 1.0
 * @since 2020/5/31 10:39
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs){
            char[] counter = new char[26];
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                counter[chars[i] - 'a']++;
            }
            String key = String.valueOf(counter);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {

        GroupAnagrams solution = new GroupAnagrams();
        solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int reverseNumber = 0;
        while (x > reverseNumber){
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
        }
        return reverseNumber == x || x == reverseNumber / 10;
    }
}
