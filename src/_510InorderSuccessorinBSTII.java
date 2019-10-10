public class _510InorderSuccessorinBSTII {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node inorderSuccessor(Node x) {
        if (x == null) return null;
        Node root = x;
        while(root.parent != null){
            root = root.parent;
        }
        return helper(root, x);
    }

    private Node helper(Node root, Node x){
        if (root == null || x == null) return null;
        Node candidate = null;
        while(root != null){
            if (x.val >= root.val){
                root = root.right;
            }else{
                candidate = root;
                root = root.left;
            }
        }
        return candidate;
    }
}
