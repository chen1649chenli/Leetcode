import java.util.ArrayList;
import java.util.List;

public class _783MinDistance {
    Integer res = Integer.MAX_VALUE, prev = null;
    public int minDiffInBST(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (prev != null) res = Math.min(res, root.val - prev);
        prev = root.val;
        if (root.right != null) minDiffInBST(root.right);

        return res;
    }
}
