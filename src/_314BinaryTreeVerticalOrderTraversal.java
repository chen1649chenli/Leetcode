import java.util.*;
public class _314BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> qNode = new LinkedList<>();
        Queue<Integer> qCol = new LinkedList<>();
        int min = 0, max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        qNode.offer(root);
        qCol.offer(0);

        while(!qNode.isEmpty() && !qCol.isEmpty()){

            int pos = qCol.poll();
            TreeNode node = qNode.poll();
            if (!map.containsKey(pos)){
                map.put(pos, new LinkedList<>());
            }
            map.get(pos).add(node.val);
            if (node.left != null) {
                qCol.offer(pos - 1);
                min = Math.min(min, pos - 1);
                qNode.offer(node.left);
            }
            if (node.right != null){
                qCol.offer(pos + 1);
                max = Math.max(max, pos + 1);
                qNode.offer(node.right);
            }
        }
        for (int i = min; i <= max; i += 1){
            List<Integer> list = new ArrayList<>();
            if (!map.containsKey(i)){
                continue;
            }else{
                ans.add(map.get(i));
            }
        }

        return ans;
    }
}
