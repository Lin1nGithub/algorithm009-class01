import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 22
 * 括号生成
 * @author linkuan
 * @version 1.0
 * @since 2020/11/10 15:58
 */
public class GenerateParenthesis {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) return res;
        backTrack(new StringBuilder(), n, n);
        return res;
    }

    private void backTrack(StringBuilder path, int left, int right){
        if (left == 0 && right == 0) {
            res.add(path.toString());
            return;
        }
        // 如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节
        if (left > right){
            return;
        }
        if (left > 0){
            backTrack(path.append("("), left - 1, right);
            path.deleteCharAt(path.length() - 1);
        }
        if (right > 0){
            backTrack(path.append(")"), left, right - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis solution = new GenerateParenthesis();
        solution.generateParenthesis(3);
    }
}
