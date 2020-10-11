import java.util.List;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 环形链表II
 * 142
 * @author linkuan
 * @version 1.0
 * @since 2020/10/10 23:41
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {

        ListNode fast,slow;
        fast = slow = head;

        while (fast != null && fast.next != null){

            fast = fast.next.next;

            slow = slow.next;

            // 确定该链表是环形
            if (fast == slow){

                // 只要我们把快慢指针中的任一个重新指向 head，
                // 然后两个指针同速前进，k - m 步后就会相遇，相遇之处就是环的起点了。
                slow = head;
                while (slow != fast){

                    fast = fast.next;

                    slow = slow.next;
                }

                return slow;
            }
        }

        return null;
    }
}
