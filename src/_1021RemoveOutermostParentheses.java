import java.util.Stack;

public class _1021RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        StringBuilder str = new StringBuilder();
        int open = 0;
        for (char c : S.toCharArray()){
            if (c == '(' && open++ > 0) str.append(c);
            if (c == ')' && open-- > 1) str.append(c);
        }
        return str.toString();
    }
}
