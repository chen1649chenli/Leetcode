public class _141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null ){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
