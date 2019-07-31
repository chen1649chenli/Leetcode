public class _002AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        int carry = 0;
        int sum;
        ListNode ans = new ListNode(Integer.MAX_VALUE);
        ListNode ptr = ans;
        while(a != null || b != null){
            if (a == null){
                sum = (b.val + carry)  % 10;
                carry = (carry + b.val) / 10;
                b = b.next;
            } else if (b == null){
                sum = (a.val + carry)  % 10;
                carry = (carry + a.val) / 10;
                a = a.next;
            } else{
                sum = (a.val + b.val + carry)  % 10;
                carry = (carry + a.val + b.val) / 10;
                a = a.next;
                b = b.next;
            }
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }
        if (carry == 1) ptr.next = new ListNode(carry);
        return ans.next;
    }
}
