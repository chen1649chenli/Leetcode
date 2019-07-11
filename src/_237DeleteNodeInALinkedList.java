public class _237DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        ListNode ptr = node;
        while(ptr.next.next != null){
            ptr.val = ptr.next.val;
            ptr = ptr.next;
        }
        ptr.val = ptr.next.val;
        ptr.next = null;
    }
}
