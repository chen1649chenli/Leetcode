public class _114FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return;

        flatten(root.left);
        flatten(root.right);
        if (root.left == null){
            return;
        }else{
            TreeNode curr = root.left;

            while(curr.right != null){
                curr = curr.right;
            }
            curr.right = root.right;
            root.right = root.left;
            root.left = null;
            return;
        }
    }
}
