public class _938RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        /** Add base case */
        if (root == null) return 0;
        /** Exclude left branch if node val < L*/
        if (root.val < L) return rangeSumBST(root.right, L, R);
        /** Exclude right branch if node val > R*/
        if (root.val > R) return rangeSumBST(root.left, L, R);
        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
    }
}
