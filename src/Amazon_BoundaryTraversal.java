public class Amazon_BoundaryTraversal {
    TreeNode root;

    private void printLeaves(TreeNode node){
        if (node == null) return;
        if (node.left == null && node.right == null){
            System.out.print(node.val + " ");
        }
        printLeaves(node.left);
        printLeaves(node.right);
    }

    private void printLeft(TreeNode node){
        if (node == null) return;
        if (node.left != null){
            System.out.print(node.val + " ");
            printLeft(node.left);
        }else if (node.right != null){
            System.out.print(node.val + " ");
            printLeft(node.right);
        }
    }

    private void printRight(TreeNode node){
        if (node == null) return;
        if (node.right != null){
            System.out.print(node.val + " ");
            printRight(node.right);
        }else if(node.left != null){
            System.out.print(node.val + " ");
            printRight(node.left);
        }
    }

    public void printBoundary(TreeNode root){
        if (root != null){
            System.out.print(root.val + " ");
        }
        printLeft(root.left);
        printLeaves(root);
        printRight(root.right);
    }

    public static void main(String[] args) {
        Amazon_BoundaryTraversal tree = new Amazon_BoundaryTraversal();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);
        tree.root.right = new TreeNode(22);
        tree.root.right.right = new TreeNode(25);
        tree.printBoundary(tree.root);
    }



}
