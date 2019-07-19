class _155MinStack {


    /** initialize your data structure here. */
    private static class node {
        int val;
        int min;
        node next;

        node (int value, node next){
            this.val = value;
            this.min = this.val;
            this.next = next;
        }
        
    }

    int min = Integer.MAX_VALUE;
    node sentinel;


    public _155MinStack() {
        this.min = Integer.MAX_VALUE;
        this.sentinel = new node(Integer.MAX_VALUE, null);

    }

    public void push(int x) {
        sentinel.next = new node(x, sentinel.next);
        this.min = Math.min(this.min, x);
        sentinel.next.min = this.min;
    }

    public void pop() {
        sentinel.next = sentinel.next.next;
        if (sentinel.next == null){
            this.min = Integer.MAX_VALUE;
        }else{
            this.min = sentinel.next.min;
        }

    }

    public int top() {
        return sentinel.next.val;

    }

    public int getMin() {
        return this.min;
    }
}
