package BST;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/9/27 18:43
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}
