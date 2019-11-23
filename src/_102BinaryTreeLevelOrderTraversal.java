import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> list = new ArrayList<>();
        while(q.size() > 1){
            TreeNode node = q.poll();
            if (node == null){
                ans.add(new ArrayList<>(list));
                list = new ArrayList<>();
                q.offer(null);
            }else{
                list.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        ans.add(new ArrayList<>(list));
        return ans;
    }
}
