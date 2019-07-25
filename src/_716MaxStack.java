import java.util.Stack;

public class _716MaxStack {
    Stack<Node> stack;

    private class Node{
        int val;
        int max;

        Node(int x, int y){
            this.val = x;
            this.max = y;
        }
    }

    public _716MaxStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Node(x, x));
        }else{
            int prevMax = peekMax();
            if (x > prevMax){
                stack.push(new Node(x, x));
            }else{
                stack.push(new Node(x, prevMax));
            }
        }
    }

    public int pop() {
        return stack.pop().val;
    }

    public int top() {
        return stack.peek().val;
    }

    public int peekMax() {
        return stack.peek().max;

    }

    public int popMax() {
        int max = peekMax();
        Stack<Node> tmp = new Stack<>();
        Node n = stack.pop();
        while(n.val != max){
            tmp.push(n);
            n = stack.pop();
        }
        while(!tmp.isEmpty()){
            push(tmp.pop().val);
        }
        return n.val;
    }
}
