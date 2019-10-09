public class _705DesignHashSet {
    ListNode[] content;

    class ListNode{
        int key;
        ListNode next;

        ListNode(int k){
            this.key = k;
        }

        ListNode keyIndex(int k){
            ListNode prev = null;
            ListNode curr = this;
            while(curr != null && curr.key != k){
                prev = curr;
                curr = curr.next;
            }
            return prev;
        }

        void add(int k){
            ListNode node = keyIndex(k);
            if (node.next == null){
                node.next = new ListNode(k);
            }
        }

        void remove(int k){
            ListNode node = keyIndex(k);
            if (node.next == null) return;
            node.next = node.next.next;
        }

        boolean contains(int k){
            ListNode node = keyIndex(k);
            if (node.next == null) return false;
            return true;
        }
    }

    /** Initialize your data structure here. */
    public _705DesignHashSet() {
        content = new ListNode[10000];
    }

    public void add(int key) {
        int idx = Integer.hashCode(key) % content.length;
        if (content[idx] == null) content[idx] = new ListNode(-1);
        content[idx].add(key);
    }

    public void remove(int key) {
        int idx = Integer.hashCode(key) % content.length;
        if (content[idx] == null) return;
        content[idx].remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx = Integer.hashCode(key) % content.length;
        if (content[idx] == null) return false;
        return content[idx].contains(key);
    }
}
