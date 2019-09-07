import java.util.ArrayList;
import java.util.List;

public class _017LetterCombinations {
    public List<String> letterCombinations(String digits) {
        String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0) return ans;
        helper(ans, digits, "", map);
        return ans;
    }

    private void helper(List<String> ans, String digits, String str, String[] map){
        int l = str.length();
        if (l == digits.length()){
            ans.add(str);
            return;
        }
        char c = digits.charAt(l);
        int c_ = Integer.parseInt(Character.toString(c));
        for (char nextChar : map[c_ - 2].toCharArray()){
            helper(ans, digits, str + nextChar, map);
        }
    }
}
