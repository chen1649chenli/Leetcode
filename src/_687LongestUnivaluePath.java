public class _687LongestUnivaluePath {
    int maxLength = 0;
    public int longestUnivaluePath(TreeNode root) {
        updateLength(root);
        return maxLength;
    }

    private int updateLength(TreeNode node){
        if (node == null) return 0;
        int left = 0;
        int right = 0;
        if (node.left != null){
            if (node.val == node.left.val){
                left = 1 + updateLength(node.left);
            }else{
                updateLength(node.left);
            }
        }

        if (node.right != null ){
            if (node.val == node.right.val){
                right = 1 + updateLength(node.right);
            }else{
                updateLength(node.right);
            }
        }

        if ((left + right) > maxLength) maxLength = left + right;
        return Math.max(left, right);
    }
}
