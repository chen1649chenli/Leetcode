import java.util.LinkedList;
import java.util.Queue;

public class _1161MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        int level = 1, minLevel = -1, total = 0, maxTotal = Integer.MIN_VALUE;;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(q.size() > 1){
            TreeNode node = q.poll();
            if (node == null){
                if (total > maxTotal){
                    maxTotal = total;
                    minLevel = level;
                }
                q.offer(null);
                level += 1;
                total = 0;
                continue;
            }else{
                total += node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return minLevel;
    }
}
