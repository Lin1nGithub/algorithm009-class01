
/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 最长公共前缀
 * 14
 *
 * @author linkuan
 * @version 1.0
 * @since 2020/10/30 14:56
 */
public class LongestCommonPrefix {

    /**
     *  令最长公共前缀 ans 的值为第一个字符串，进行初始化
     *  遍历后面的字符串，依次将其与 ans 进行比较，两两找出公共前缀，最终结果即为最长公共前缀
     *  如果查找过程中出现了 ans 为空的情况，则公共前缀不存在直接返回
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++){
                if (ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0, j);
            if (ans.equals("")){
                return ans;
            }
        }
        return ans;
    }

    class Solution{

        /**
         * 纵向比较
         * @param strs
         * @return
         */
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            int length = strs[0].length();
            int count = strs.length;
            for (int i = 0; i < length; i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < count; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c) {
                        return strs[0].substring(0, i);
                    }
                }
            }
            return strs[0];
        }
    }

    public static void main(String[] args) {

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"});
    }
}
