import java.util.*;

public class _103BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> list = new ArrayList<>();
        boolean zigzag = false;
        while(q.size() > 0){
            int cnt = q.size();
            list = new ArrayList<>();
            for (int i = 0; i < cnt; i +=1){
                TreeNode node = q.poll();
                if (zigzag){
                    list.add(0, node.val);
                }else{
                    list.add(node.val);
                }
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            zigzag = !zigzag;
            ans.add(new ArrayList(list));
        }
        return ans;
    }
}
