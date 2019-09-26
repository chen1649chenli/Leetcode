import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _297SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serial(root, new StringBuilder()).toString();

    }

    private StringBuilder serial(TreeNode node, StringBuilder sb){
        if (node == null){
            return sb.append("#").append(",");
        }
        sb.append(node.val).append(",");
        serial(node.left, sb);
        serial(node.right, sb);
        return sb;
    }

    //Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        String[]input = data.split(",");
        q.addAll(Arrays.asList(input));

        return buildTree(q);
    }

    private TreeNode buildTree(Queue<String> q){
        if (q.isEmpty()) return null;
        String str = q.poll();
        if (str.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = buildTree(q);
        node.right = buildTree(q);
        return node;
    }
}
