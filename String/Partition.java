import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * @author linkuan
 * @version 1.0
 * @since 2021/3/9 19:44
 */
public class Partition {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {

        int len = s.length();

        char[] chars = s.toCharArray();

        backTrack(chars, 0, len, new ArrayList<>());

        return res;
    }

    private void backTrack(char[] chars, int index, int len, List<String> path){
        if (len == index){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < len; i++){
            if (!isPalindrome(chars, index, i)){
                continue;
            }
            path.add(new String(chars, index, i + 1 - index));
            backTrack(chars, i + 1, len, path);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(char[] chars, int left , int right){
        while (left < right){
            if (chars[left] != chars[right]){
                return false;
            }
            left++;right--;
        }
        return true;
    }
}
