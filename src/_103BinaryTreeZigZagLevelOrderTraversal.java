import java.util.*;

public class _103BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        q.offer(root);
        q.offer(null);
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while(q.size() > 0){
            TreeNode node = q.poll();
            if (node == null){
                count += 1;
                ans.add(new ArrayList(list));
                list = new ArrayList<>();
                if(stack.isEmpty()) break;
                while(!stack.isEmpty()){
                    q.offer(stack.pop());
                }
                q.offer(null);
                continue;
            }else{
                list.add(node.val);
                if (count % 2 == 0){
                    if (node.left != null) stack.push(node.left);
                    if (node.right != null) stack.push(node.right);
                }else{
                    if(node.right != null) stack.push(node.right);
                    if(node.left != null) stack.push(node.left);
                }
            }
        }
        return ans;
    }
}
