import java.util.Stack;

public class _232ImplementQueueUsingStacks {

    Stack<Integer> queue;

    /** Initialize your data structure here. */
    public _232ImplementQueueUsingStacks() {
        queue = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> tmp = new Stack<>();
        while(!queue.isEmpty()){
            tmp.push(queue.pop());
        }
        queue.push(x);
        while(!tmp.isEmpty()){
            queue.push(tmp.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.pop();

    }

    /** Get the front element. */
    public int peek() {
        return queue.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
