import java.util.*;

public class _107LevelOrderTraversal3 {
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        if (root == null) return ans;

        int height = 0;
        ans.add(new LinkedList<>());
        while(queue.size() > 1){
            TreeNode node = queue.poll();
            if(node == null){
                height += 1;
                ans.add(new LinkedList<>());
                queue.add(null);
                continue;
            }
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

            ans.get(height).add(node.val);
        }
        Collections.reverse(ans);
        return ans;
    }

}
