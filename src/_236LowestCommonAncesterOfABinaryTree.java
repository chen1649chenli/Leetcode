import java.util.*;

public class _236LowestCommonAncesterOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        Map<TreeNode, TreeNode> dict = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left != null) {
                dict.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null){
                dict.put(node.right, node);
                queue.offer(node.right);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while(p != null){
            set.add(p);
            p = dict.getOrDefault(p, null);
        }
        while(!set.contains(q)){
            q = dict.getOrDefault(q, null);
        }
        return q;
    }
}
