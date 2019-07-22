public class _110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int depth = height(root);
        if (depth == -1) return false;
        else return true;

    }

    private int height(TreeNode node){
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return - 1;

        return Math.max(left, right) + 1;
    }
}
