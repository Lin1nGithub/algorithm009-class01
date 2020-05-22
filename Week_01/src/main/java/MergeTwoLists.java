import java.util.LinkedList;

/**
 *
 * 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @author linkuan
 * @version 1.0
 * @since 2020/5/22 16:03
 */
public class MergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 暴力法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsForce(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                // 将虚拟节点指向l1
                prev.next = l1;
                // 将l1指向下一个节点
                l1 = l1.next;
            }else {
                // 将虚拟节点指向l2
                prev.next = l2;
                // 将l2指向下一个节点
                l2 = l2.next;
            }
            // prev指向下一个节点
            prev = prev.next;
        }

        prev = l1 == null ? l1 : l2;
        return prehead.next;
    }

    /**
     * 两个链表头部值较小的一个节点与剩下元素的 merge 操作结果合并
     * 采用递归的方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l1;
        }else if (l2 == null){
            return l2;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
