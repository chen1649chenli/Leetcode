import java.util.LinkedList;
import java.util.Queue;

public class _111MinDepthBT {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0){
            return left + right + 1;
        }else{
            return Math.min(left, right) + 1;
        }
    }
}
