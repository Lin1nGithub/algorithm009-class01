import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 234
 * @author linkuan
 * @version 1.0
 * @since 2020/10/23 10:15
 */
public class IsPalindrome {

    /**
     * 链表转数组
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (null == head) return true;
        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        while (node != null){
            list.add(node.val);
            node = node.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right){

            if (!list.get(left).equals(list.get(right))){
                return false;
            }

            left++ ; right--;
        }
        return true;
    }

    class Solution{
        /**
         * 快慢指针
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            return false;
        }
    }

    class Traverse{

        // 正序的节点
        ListNode frontPointer;
        /**
         * 利用计算机栈弹出栈顶元素的方式进行比较
         * 递归
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            frontPointer = head;
            return traverse(head);
        }

        private boolean traverse(ListNode currentNode){

            if (currentNode != null){

                if (!traverse(currentNode.next)){

                    return false;
                }

                if (currentNode.val != frontPointer.val){

                    return false;
                }

                frontPointer = frontPointer.next;
            }
            return true;
        }
    }
}
