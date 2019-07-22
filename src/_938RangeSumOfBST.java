public class _938RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if (root != null) sum = helper(root, sum, L, R);
        return sum;
    }

    private int helper(TreeNode node, int val, int L, int R){
        if (node == null) return val;
        if (node.val >=L && node.val <= R) val += node.val;


        val = helper(node.left, val, L, R);
        val = helper(node.right, val, L, R);

        return val;
    }
}
