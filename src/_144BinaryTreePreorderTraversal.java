import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        if (root == null) return ans;
        while(root != null || !q.isEmpty()){
            while(root != null){
                ans.add(root.val);
                q.push(root);
                root = root.left;
            }
            root = q.pop().right;
        }
        return ans;
    }
}
