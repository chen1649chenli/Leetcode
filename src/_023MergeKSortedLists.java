import java.util.PriorityQueue;

public class _023MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null ||lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) ->(a.val - b.val));
        for (ListNode node: lists){
            if (node != null){
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode tmp = pq.poll();
            curr.next = tmp;
            curr = curr.next;
            tmp = tmp.next;
            if (tmp != null){
                pq.offer(tmp);
            }
        }
        return dummy.next;
    }
}
