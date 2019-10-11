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
        Deque<Node> stack = new ArrayDeque<>();
        Queue<Node> q = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            q.offer(root);
            root = root.right;
        }
        Node head = q.poll();
        Node prev = null, curr = head;
        while(!q.isEmpty()){
            prev = curr;
            curr = q.poll();
            curr.left = prev;
            prev.right = curr;
        }
        curr.right = head;
        head.left = curr;
        return head;
    }
}
