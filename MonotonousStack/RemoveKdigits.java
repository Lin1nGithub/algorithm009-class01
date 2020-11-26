import java.util.*;

/**
 * https://leetcode-cn.com/problems/remove-k-digits/
 * 移掉K位数字
 * 402
 * @author linkuan
 * @version 1.0
 * @since 2020/11/16 10:54
 */
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        if (num.length() < k) return "0"; // 判断特殊情况。
        Deque<Character> dq = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            //当且仅当K>0 并且队尾元素大于要入队的元素的时候就把队尾元素移除掉
            while (k > 0 && !dq.isEmpty() && dq.peekLast() > num.charAt(i)){
                dq.pollLast();
                k--;
            }
            // 不让前导0入栈
            if (!dq.isEmpty() || num.charAt(i) != '0'){
                dq.offerLast(num.charAt(i));
            }
        }
        //此时如果K还大于0 队列里面的元素已经为单调不降了。则最后依次移除队列尾部剩余的k数次即可，
        //拿123456728 k=7 举例说明
        //入队完后 队列里面为1228 此时k=2 所以还需要依次移除尾部2和8  剩余12即为最小
        while (k > 0 && !dq.isEmpty()){
            dq.pollLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()){
            sb.append(dq.pollFirst());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        RemoveKdigits solution = new RemoveKdigits();
        solution.removeKdigits("1432219"
                ,3);
    }

}
