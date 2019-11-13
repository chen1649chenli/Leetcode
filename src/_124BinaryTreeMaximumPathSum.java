public class _124BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return this.max;
    }

    private int helper(TreeNode root){
        if (root == null) return 0;
        int leftMax = Math.max(helper(root.left), 0);
        int rightMax = Math.max(helper(root.right), 0);
        this.max = Math.max(this.max, leftMax + rightMax + root.val);
        return Math.max(leftMax, rightMax) + root.val;
    }
}
