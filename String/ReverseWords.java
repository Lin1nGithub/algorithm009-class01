/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 151
 * 翻转字符串里的单词
 * @author linkuan
 * @version 1.0
 * @since 2020/10/30 16:31
 */
public class ReverseWords {

    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1, i = j;

        StringBuilder sb = new StringBuilder();
        while (i >= 0){
            while (i >=0 && s.charAt(i) != ' '){ // 找到单词的头
                i--;
            }
            sb.append(s.substring(i + 1, j + 1)).append(" "); // 将匹配的单词放入sb中
            while (i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            j = i; // 将j放在单词尾
        }

        return sb.substring(0, sb.length() - 1);
    }

    class Solution{
        /**
         * 库函数选手
         * @param s
         * @return
         */
        public String reverseWords(String s) {
            if (s.length() == 0) return "";
            String[] s1 = s.split(" ");
            StringBuilder sb = new StringBuilder();
            int right = s1.length - 1;
            while (right >= 0){
                if (s1[right].length() > 0){
                    sb.append(s1[right]);
                    sb.append(" ");
                }
                right--;
            }
            return sb.substring(0, sb.length() - 1);
        }
    }



    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        reverseWords.reverseWords("the sky is blue");
    }
}
