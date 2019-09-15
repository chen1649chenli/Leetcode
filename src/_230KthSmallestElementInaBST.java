import java.util.ArrayDeque;
import java.util.Deque;

public class _230KthSmallestElementInaBST {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) break;

            root = root.right;
        }
        return root.val;
    }
}
