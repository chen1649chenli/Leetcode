import java.util.*;
public class _150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String str : tokens){
            if (str.equals("+")){
                int res = stack.pop() + stack.pop();
                stack.push(res);
            }else if (str.equals("-")){
                int res = -stack.pop() + stack.pop();
                stack.push(res);
            }else if (str.equals("*")){
                int res = stack.pop() * stack.pop();
                stack.push(res);
            }else if (str.equals("/")){
                int _1 = stack.pop();
                int _2 = stack.pop();
                int res = _2 / _1;
                stack.push(res);
            }else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
