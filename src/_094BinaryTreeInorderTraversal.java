import java.util.ArrayList;
import java.util.List;

public class _094BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        tranverse(ans, root);
        return ans;
    }

    private void tranverse(List<Integer> ans, TreeNode node){
        if (node == null) return;
        tranverse(ans, node.left);
        ans.add(node.val);
        tranverse(ans, node.right);
    }

}
