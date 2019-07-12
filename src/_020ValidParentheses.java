import java.util.Stack;
public class _020ValidParentheses {
    public boolean isValid(String s) {
        int size = s.length();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if (c == '('){
                stack.push(')');
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
