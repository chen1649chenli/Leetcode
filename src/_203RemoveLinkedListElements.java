public class _203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head;
        ListNode prev = fakeHead;

        while (curr != null){
            if (curr.val == val){
                prev.next = curr.next;
                curr = prev.next;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }

        return fakeHead.next;
    }
}
