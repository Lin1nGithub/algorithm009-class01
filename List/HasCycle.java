/**
 * 链表是否闭环
 * @author linkuan
 * @version 1.0
 * @since 2020/10/9 17:50
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {

        // 链表为空或者链表只有一个节点 返回false
        if (head == null || head.next == null){

            return false;
        }

        ListNode fast,slow;
        fast = slow = head;

        while (fast != null && fast.next != null){

            fast = fast.next.next;

            slow = slow.next;

            // 找到环
            if (slow == fast){

                return true;
            }
        }

        return false;
    }
}
