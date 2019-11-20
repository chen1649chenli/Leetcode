public class _337HouseRobberIII {
    public int rob(TreeNode root) {
        int[] ans = new int[2];
        ans = helper(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] helper(TreeNode root){
        if (root == null) return new int[2];

        int[] res1 = helper(root.left);
        int[] res2 = helper(root.right);
        int[] res = new int[2];
        res[0] = res1[1] + res2[1] + root.val;
        res[1] = Math.max(res1[0], res1[1]) + Math.max(res2[0], res2[1]);
        return res;
    }
}
