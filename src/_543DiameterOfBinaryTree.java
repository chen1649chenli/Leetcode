public class _543DiameterOfBinaryTree {
    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateMax(root);
        return this.max;

    }

    private int calculateMax(TreeNode node){
        if (node == null) return 0;
        int leftDepth = calculateMax(node.left);
        int rightDepth = calculateMax(node.right);
        this.max = Math.max(this.max, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
