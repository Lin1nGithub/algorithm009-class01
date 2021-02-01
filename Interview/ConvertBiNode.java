
public class ConvertBiNode {

    TreeNode head = new TreeNode(-1);

    TreeNode pre = head;

    public TreeNode convertBiNode(TreeNode root) {
        helper(root);
        return head.right;
    }

    private void helper(TreeNode root){

        if(root == null) return;

        helper(root.left);

        root.left = null;

        pre.right = root;

        pre = root;

        helper(root.right);
    }

    public static void main(String[] args) {
        ConvertBiNode solution = new ConvertBiNode();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        solution.convertBiNode(root);
    }
}
