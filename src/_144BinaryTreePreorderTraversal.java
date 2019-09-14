import java.util.ArrayList;
import java.util.List;

public class _144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorderTraversal(root, ans);
        return ans;
    }

    private void preorderTraversal(TreeNode node, List<Integer> ans){
        if (node == null) return;
        ans.add(node.val);
        preorderTraversal(node.left, ans);
        preorderTraversal(node.right, ans);
    }
}
