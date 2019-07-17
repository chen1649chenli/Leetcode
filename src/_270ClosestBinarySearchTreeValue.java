public class _270ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int ret = root.val;
        while(root != null){
            if (Math.abs(ret - target) > Math.abs(root.val - target)){
                ret = root.val;
            }
            root = (root.val > target) ?root.left : root.right;
        }
        return ret;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
}
