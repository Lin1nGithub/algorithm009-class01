import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @author linkuan
 * @version 1.0
 * @since 2020/9/1 9:56 下午
 */
public class LetterCombinations {

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return res;
        }

        char[] chars = digits.toCharArray();

        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9',"wxyz");

        backtrack("", chars, 0, phoneMap);

        return res;
    }

    private void backtrack(String s, char[] chars, int depth, Map<Character, String> phoneMap){
        if (depth == chars.length){
            res.add(s);
            return;
        }
        String keyWord = phoneMap.get(chars[depth]);
        for (int j = 0; j < keyWord.length(); j++){
            backtrack(s + keyWord.charAt(j), chars, depth + 1, phoneMap);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations("23");
        for (String string : strings) {
            System.out.println(string);
        }

    }
}
