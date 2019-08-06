import java.util.*;

public class _022GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<String>();

        char[] chs = new char[2 * n];
        for (int i = 0; i < 2* n; i += 1){
            chs[i] = ' ';
        }
        chs[0] = '(';
        Queue<String> q = new LinkedList<>();
        q.offer(String.valueOf(chs));
        for (int i = 1; i < 2*n; i++){
            int size = q.size();
            for (int j = 0; j < size; j++){
                String s = q.poll();
                if (validLeft(s, i)){
                    char[] chs_ = s.toCharArray();
                    chs_[i] = '(';
                    q.offer(String.valueOf(chs_));
                }
                if (validRight(s, i)){
                    char[] chs_ = s.toCharArray();
                    chs_[i] = ')';
                    q.offer(String.valueOf(chs_));
                }
            }
        }
        return new LinkedList<>(q);
    }

    private boolean validLeft(String s, int i){
        int count = 0;
        for (int k = 0; k < i; k++){
            if(s.charAt(k) == '('){
                count ++;
            }
        }
        return (count < s.length() / 2);
    }

    private boolean validRight(String s, int j){
        Stack<Character> stack = new Stack<>();
        for (int k = 0; k < j; k++){
            if (s.charAt(k) == '('){
                stack.push('(');
            }else{
                stack.pop();
            }
        }
        if (!stack.isEmpty() && stack.peek() =='('){
            return true;
        }else{
            return false;
        }
    }
}
