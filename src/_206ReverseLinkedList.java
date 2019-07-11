import java.util.Stack;

public class _206ReverseLinkedList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int v){
            this.val = v;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
}
