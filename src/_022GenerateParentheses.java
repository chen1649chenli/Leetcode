import java.util.*;

public class _022GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<String>();
        List<String> str = new ArrayList<>();
        helper(str, "", 0, 0, n);
        return str;
    }

    private void helper(List<String> str_, String s, int i, int j, int n){
        if (i == n && j == n){
            str_.add(s);
            return;
        }
        if (i < n){
            helper(str_, s + "(", i+1, j, n);
        }

        if ( j < i){
            helper(str_, s+ ")", i, j+1, n);
        }
    }
}
