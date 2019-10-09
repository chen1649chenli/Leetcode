public class _706DesignHashMap {
    private ListNode[] nodes;;


    /** Initialize your data structure here. */
    public _706DesignHashMap() {
        this.nodes = new ListNode[10000];

    }

    private int hash(int i) {
        return Integer.hashCode(i) % nodes.length;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hash(key);
        if(nodes[index] == null) {
            nodes[index] = new ListNode(-1, -1);
        }
        nodes[index].put(key, value);

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
        if(nodes[index] == null) {
            return -1;
        }
        return nodes[index].get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hash(key);
        if(nodes[index] == null) {
            return;
        }
        nodes[index].remove(key);

    }

    private class ListNode {
        private int key;
        private int value;
        private ListNode next;

        private ListNode(int k, int v) {
            this.key = k;
            this.value = v;
        }

        private ListNode keyIndex(int k) {
            ListNode prev = null;
            ListNode node = this;
            while(node != null && node.key != k) {
                prev = node;
                node = node.next;
            }
            return prev;

        }

        public void put (int k, int v) {
            ListNode node = keyIndex(k);
            if (node.next == null ) {
                node.next = new ListNode(k, v);
            } else {
                node.next.value = v;
            }

        }

        public int get(int k) {
            ListNode node = keyIndex(k);
            if (node.next == null) {
                return -1;
            }
            return node.next.value;
        }

        public void remove(int k) {
            ListNode node = keyIndex(k);
            if (node.next == null) {
                return;
            }
            node.next = node.next.next;
        }
    }
}
