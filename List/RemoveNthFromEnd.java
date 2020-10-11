/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 删除链表的倒数第N个节点
 * @author linkuan
 * @version 1.0
 * @since 2020/10/9 18:15
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);// 初始化哑节点
        dummy.next = head; // 头节点指向哑节点

        ListNode first,second;
        first = second = dummy;

        // 使得first和second节点恒定相差n
        for (int i = 0; i < n + 1; i++){

            first = first.next;
        }

        // 同时前进两个节点
        // 当first节点到达终点,second节点离终点相差n个节点
        while (first != null){

            first = first.next;

            second = second.next;
        }

        // 删除第n个节点
        second.next = second.next.next;

        return dummy.next;
    }
}
