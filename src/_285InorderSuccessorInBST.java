public class _285InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        TreeNode succ = null;
        while(root != null){
            if (p.val >= root.val){
                root = root.right;
            }else{
                succ = root;
                root = root.left;
            }
        }
        return succ;
    }
}
