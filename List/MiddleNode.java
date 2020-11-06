/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 867
 * 链表的中间结点
 * @author linkuan
 * @version 1.0
 * @since 2020/11/5 11:17
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        int count = 0;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            count++;
        }
        return count / 2 == 0 ? slow : slow.next;
    }
}
