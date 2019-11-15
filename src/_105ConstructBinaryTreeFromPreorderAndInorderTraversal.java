import java.util.HashMap;
import java.util.Map;

public class _105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i += 1){
            map.put(inorder[i], i);
        }
        return helper(0, 0, inorder.length - 1, preorder, inorder, map);
    }

    private TreeNode helper(int rootIdx, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> map){
        if(inEnd < inStart || rootIdx >= preorder.length) return null;

        int val = preorder[rootIdx];
        TreeNode root = new TreeNode(val);
        int pos = map.get(val);

        TreeNode leftNode = helper(rootIdx + 1, inStart, pos - 1, preorder, inorder, map);

        TreeNode rightNode = helper(rootIdx + 1 + pos - inStart, pos + 1, inEnd, preorder, inorder, map);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
