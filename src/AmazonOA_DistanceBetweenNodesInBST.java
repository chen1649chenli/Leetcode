public class AmazonOA_DistanceBetweenNodesInBST {
    public int bstDistance(int[] nums, int node1, int node2){
        TreeNode root = buildBST(nums, node1, node2);
        TreeNode lca = lca(root, node1, node2);
        return getDistance(lca, node1) + getDistance(lca, node2);
    }

    private int getDistance(TreeNode source, int dest){
        if (source == null || source.val == dest) return 0;
        TreeNode node;
        if (source.val < dest){
            node = source.right;
        }else{
            node = source.left;
        }
        return getDistance(node, dest) + 1;
    }

    private TreeNode lca(TreeNode root, int node1, int node2){
        if (root == null) return null;
        if (root.val < node1 && root.val < node2){
            return lca(root.right, node1, node2);
        }else if (root.val > node1 && root.val > node2){
            return lca(root.left, node1, node2);
        }else{
            return root;
        }
    }


    private TreeNode buildBST(int[] nums, int node1, int node2){
        TreeNode root = null;
        boolean found1 = false, found2 = false;
        for (int node: nums){
            if (node == node1) found1 = true;
            if (node == node2) found2 = true;
            root = addToBST(root, node);
        }

        if (!found1 || !found2) return null;
        return root;
    }

    private TreeNode addToBST(TreeNode root, int val){
        if (root == null){
            root = new TreeNode(val);
            return root;
        }
        TreeNode curr = root;
        while(true){
            if (curr.val > val){
                if (curr.left != null){
                    curr = curr.left;
                }else{
                    curr.left = new TreeNode(val);
                    break;
                }
            }else{
                if (curr.right != null){
                    curr = curr.right;
                }else{
                    curr.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
