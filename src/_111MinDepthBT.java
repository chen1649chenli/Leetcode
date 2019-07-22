import java.util.LinkedList;
import java.util.Queue;

public class _111MinDepthBT {
    public int minDepth(TreeNode root) {
        int depth = 1;
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(q.size() > 1){
            TreeNode node = q.poll();
            if (node == null) {
                depth += 1;
                q.add(null);
                continue;
            }
            if (node.left == null & node.right == null) return depth;
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        return depth;
    }
}
