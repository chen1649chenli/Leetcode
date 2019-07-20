import java.util.Stack;

public class _1047RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()){
            if (!stack.isEmpty() && c == stack.peek()){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}
