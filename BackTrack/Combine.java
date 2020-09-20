import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * https://leetcode-cn.com/problems/combinations/
 * @author linkuan
 * @version 1.0
 * @since 2020/9/20 6:02 下午
 */
public class Combine {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        if (n == 0 || k == 0){

            return res;
        }

        List<Integer> path = new ArrayList<>();

        backTrack(n, k , 1 , path);

        return res;
    }

    private void backTrack(int n, int k, int start,List<Integer> path){

        if (k == path.size()){

            res.add(new ArrayList<>(path));

            return;
        }

        for (int i = start ; i <= n ;i++){

            path.add(i);

            backTrack(n, k, i + 1, path);

            path.remove(path.size() - 1);
        }
    }
}
