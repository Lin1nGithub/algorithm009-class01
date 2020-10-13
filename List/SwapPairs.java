/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 24
 * 两两交换链表中的节点
 * @author linkuan
 * @version 1.0
 * @since 2020/10/13 10:22
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null){

            ListNode slow = cur.next;
            ListNode fast = cur.next.next;

            // 两两交换
            cur.next = fast;
            slow.next = fast.next;
            fast.next = slow;
            cur = slow;
        }

        return dummy.next;
    }
}
