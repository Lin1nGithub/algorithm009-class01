package reverse;

/**
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 206
 * @author linkuan
 * @version 1.0
 * @since 2020/11/3 16:46
 */
public class ReverseList {

    class Solution{

    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        return reverse(head);
    }

    ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
