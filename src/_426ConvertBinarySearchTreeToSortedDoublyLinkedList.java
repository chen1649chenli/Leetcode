import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _426ConvertBinarySearchTreeToSortedDoublyLinkedList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node dummy = new Node();
        Node prev = dummy;

        Deque<Node> stack = new ArrayDeque<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            prev.right = root;
            root.left = prev;
            prev = root;
            root = root.right;
        }
        Node head = dummy.right;
        prev.right = head;
        head.left = prev;

        return head;
    }
}
