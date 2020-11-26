/**
 * 对链表进行插入排序
 * 147
 * @author linkuan
 * @version 1.0
 * @since 2020/11/20 10:57
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = head, curr = head.next;
        while (curr != null) {
            if (slow.val <= curr.val) {
                slow = slow.next;
            } else {
                ListNode prev = dummy;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                slow.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = slow.next;
        }
        return dummy.next;
    }
}
