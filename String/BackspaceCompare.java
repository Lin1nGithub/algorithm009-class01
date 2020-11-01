import java.util.ArrayList;
import java.util.List;

/**
 * 比较含退格的字符串
 * 844
 * https://leetcode-cn.com/problems/backspace-string-compare/
 * @author linkuan
 * @version 1.0
 * @since 2020/10/19 10:31
 */
public class BackspaceCompare {

    final char symbol = '#';

    /**
     * 逆序比较字符,如果遇到#号则用跳过下一个字符,
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1, back;
        while (true) {
            back = 0;
            while (i >= 0 && (back > 0 || S.charAt(i) == '#')) {
                back += S.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            back = 0;
            while (j >= 0 && (back > 0 || T.charAt(j) == '#')) {
                back += T.charAt(j) == '#' ? 1 : -1;
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return i == -1 && j == -1;
    }

    public static void main(String[] args) {

        BackspaceCompare backspaceCompare = new BackspaceCompare();

        boolean result = backspaceCompare.backspaceCompare("xywrrmp","xywrrmu#p");
        System.out.println(result);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first,second;
        first = second = dummy;
        for (int i = 0;i < n + 1; i++){
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
