//        617 Merge Two Binary Trees
//        Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
//
//        You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
//
//        Example 1:
//
//        Input:
//        Tree 1                     Tree 2
//        1                         2
//        / \                       / \
//        3   2                     1   3
//        /                           \   \
//        5                             4   7
//        Output:
//        Merged tree:
//        3
//        / \
//        4   5
//        / \   \
//        5   4   7

public class _617MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return helper(t1, t2);
    }

    private TreeNode helper(TreeNode n1, TreeNode n2){
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        TreeNode root = new TreeNode(n1.val + n2.val);
        root.left = helper(n1.left, n2.left);
        root.right = helper(n1.right, n2.right);
        return root;
    }
}
