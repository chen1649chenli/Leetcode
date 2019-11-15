import java.util.HashMap;
import java.util.Map;

public class _106ConstructBinaryTreFromInorderAndPostOrderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++){
            map.put(inorder[i], i);
        }

        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder, map);

    }

    private TreeNode helper(int parentNodeIdx, int inStart, int inEnd, int[] inorder, int[] postorder, Map<Integer, Integer> map){
        if (inStart > inEnd || parentNodeIdx < 0) return null;

        int val = postorder[parentNodeIdx];
        TreeNode parent = new TreeNode(val);
        int pos = map.get(val);
        parent.left = helper(parentNodeIdx - inEnd + pos - 1 , inStart, pos - 1, inorder, postorder, map);
        parent.right = helper(parentNodeIdx - 1, pos + 1, inEnd, inorder, postorder, map);
        return parent;
    }
}
