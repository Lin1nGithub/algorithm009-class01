import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 合并K个升序链表
 * @Author kuan.lin
 * @Date 2021/6/7 19:53
 * @Version 1.0
 */
public class MergeKLists {

    /**
     * O(nk)
     * 参考 合并两个有序链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode list : lists){
            res = mergeTwoLists(res, list);
        }
        return res;
    }

    /**
     * 两两合并 - 递归
     * 优化 mergeKLists
     * O(Nlogk)
     * @param lists
     * @return
     */
    public ListNode mergeKListsMerge(ListNode[] lists){
        if (lists.length == 0) return null;
        return merge(lists, 0, lists.length -1);
    }

    private ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi){
            return lists[lo];
        }
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid + 1, hi);
        return mergeTwoLists(l1, l2);
    }

    /**
     * 最小根
     * 时间复杂度：O(NlogK)
     * @param lists
     * @return
     */
    public ListNode mergeKListsQueue(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node : lists){
            if (null != node){
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!pq.isEmpty()){
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null){
                pq.offer(minNode.next);
            }
        }

        return dummy.next;
    }


    /**
     * 两数相加
     * @param l1
     * @param l2
     * @return
     */
    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }

            if (carry == 1){
                cur.next = new ListNode(1);
            }
        }

        return pre.next;
    }

    /**
     * 删除链表的倒数第N个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first, second;
        first = second = dummy;
        for (int i = 0; i < n + 1; i++){
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val > l2.val){
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }

    /**
     * 环形链表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast, slow;
        fast = slow = dummy.next;
        while (fast != null &&  fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
