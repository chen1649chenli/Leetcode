import java.util.LinkedList;
import java.util.Queue;

public class _993Cousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;
        q.add(root);
        q.add(null);
        int xDepth = -1, yDepth = -2;
        while(q.size() > 1){
            TreeNode n = q.poll();
            if (n == null){
                depth += 1;
                q.add(null);
                continue;
            }
            if (n.val == x) xDepth = depth;
            if (n.val == y) yDepth = depth;
            if (n.left != null && n.right != null){
                if (n.left.val == x && n.right.val == y) return false;
                if (n.left.val == y && n.right.val == x) return false;
            }
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        return (xDepth == yDepth);
    }
}
