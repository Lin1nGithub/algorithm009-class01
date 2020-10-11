import java.util.List;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 删除排序链表中的重复元素
 * 83
 * @author linkuan
 * @version 1.0
 * @since 2020/10/9 22:25
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {

        if (null == head || head.next == null){

            return head;
        }

        ListNode fast,slow;
        fast = slow = head;

        while (fast != null){

            if (fast.val != slow.val){

                // nums[slow] = nums[fast];
                slow.next = fast;

                // slow++;
                slow = slow.next;
            }

            // fast++
            fast = fast.next;
        }

        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }
}
