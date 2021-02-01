import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 01，01
 */
public class IsUnique {

    public boolean isUnique(String astr) {

        // 大小写字母
        int[] counter = new int[26];

        Arrays.fill(counter, 0);

        for (int i = 0; i < astr.length(); i++){

            char c = astr.charAt(i);

            if (counter[c - 'a'] > 0){

                return false;
            }

            counter[c - 'a']++;
        }

        return true;
    }

    /**
     * 位运算
     */
    class Solution {

        public boolean isUnique(String astr) {
            long bits = 0;
            int size = astr.length();
            for (int i = 0; i < size; i++) {
                int move = astr.charAt(i) - 'A';
                if ((bits & (1L << move)) != 0) {
                    //有重复的，直接返回false
                    return false;
                } else {
                    //标记当前位置有这个字符
                    bits |= (1L << move);
                }
            }
            return true;
        }
    }

}
