public class _98ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, int lo, int hi){

        if (node == null){
            return true;
        }
        if (node.val < lo || node.val > hi) return false;

        if (node.left == null && node.right == null){
            return true;
        }else if (node.left == null){
            return  (node.val < node.right.val) && isValid(node.right, node.val + 1, hi);
        }else if (node.right == null){
            return (node.val > node.left.val) && isValid(node.left, lo, node.val - 1);
        }else{
            return  (node.val > node.left.val && node.val < node.right.val) && isValid(node.left, lo, node.val - 1) && isValid(node.right, node.val + 1, hi);
        }
    }
}
