public class _083RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null){
            if (curr.val != prev.val){
                prev = curr;
                curr = curr.next;
            }else{
                prev.next = curr.next;
                curr = curr.next;
            }
        }
        return head;
    }
}
