import java.util.*;

public class _257BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();
        String str = "";
        if (root != null) dfs(root, str, ans);
        return ans;
    }

    private void dfs(TreeNode node, String str, List<String> list){

        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left == null && right == null) list.add(str + node.val);
        if (left != null) dfs(left, str + node.val + "->", list);
        if (right != null) dfs(right, str + node.val + "->", list);
    }
}
