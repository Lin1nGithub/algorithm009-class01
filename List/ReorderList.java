import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reorder-list/solution/
 * 143
 * 重排链表
 * @author linkuan
 * @version 1.0
 * @since 2020/10/20 11:00
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // 线性表
        List<ListNode> listNodes = new ArrayList<>();
        ListNode next = head;
        while (next != null){
            listNodes.add(next);
            next = next.next;
        }
        int left = 0; int right = listNodes.size() - 1;
        while (left < right){

            // 首尾相接
            listNodes.get(left).next = listNodes.get(right);

            // 左指针向右移动
            left++;

            if (left == right) break;

            // 尾与首相接之后,尾与左指针向右边移动后的下一个节点相接
            listNodes.get(right).next = listNodes.get(left);

            right--;
        }
        //终止条件是l==r，此时最后一个的（lr指针重合处）next应设为null，否则大部分情况next是某个节点，构成环
        listNodes.get(left).next = null;// 置为空 防止闭环
    }

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int back;
        while (true){
            back = 0;
            while (i >= 0 && (back > 0 || S.charAt(i) == '#')){
                back += S.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            back = 0;
            while (j >=0 && (back > 0 || T.charAt(j) == '#')){
                back += T.charAt(j) == '#' ? 1 : -1;
                j--;
            }
            if (j > 0 && i > 0 && S.charAt(i) == T.charAt(j)){
                i--;
                j--;
            }else {
                break;
            }
        }
        return i == -1 && j == -1;
    }
}
