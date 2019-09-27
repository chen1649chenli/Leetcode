import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _297SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if (node == null){
                sb.append("#,");
            }else{
                sb.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data){
        String[] strs = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        if (strs[0].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        TreeNode node = root;
        q.offer(node);
        for (int i = 1; i < strs.length; i += 1){
            node = q.poll();
            if(strs[i].equals("#")){
                node.left = null;
            }else{
                node.left = new TreeNode(Integer.parseInt(strs[i]));
                q.offer(node.left);
            }
            i = i + 1;
            if(strs[i].equals("#")){
                node.right = null;
            }else{
                node.right = new TreeNode(Integer.parseInt(strs[i]));
                q.offer(node.right);
            }
        }
        return root;
    }
}
