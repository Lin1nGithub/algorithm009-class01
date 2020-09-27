package BST;

/**
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * 109
 * 有序链表转换二叉搜索树
 * @author linkuan
 * @version 1.0
 * @since 2020/9/27 18:41
 */
public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {

        //边界条件的判断
        if (head == null){

            return null;
        }
        if (head.next == null){

            return new TreeNode(head.val);
        }
        //这里通过快慢指针找到链表的中间结点slow，pre就是中间
        //结点slow的前一个结点
        ListNode slow = head;

        ListNode fast = head;

        ListNode pre = null;

        while (fast != null && fast.next != null) {

            pre = slow;

            slow = slow.next;

            fast = fast.next.next;
        }

        //链表断开为两部分，一部分是node的左子节点，一部分是node
        //的右子节点
        pre.next = null;

        //node就是当前节点
        TreeNode node = new TreeNode(slow.val);

        //从head节点到pre节点是node左子树的节点
        node.left = sortedListToBST(head);

        //从slow.next到链表的末尾是node的右子树的结点
        node.right = sortedListToBST(slow.next);

        return node;
    }
}
