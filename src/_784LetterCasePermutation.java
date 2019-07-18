import java.util.List;
import java.util.ArrayList;

public class _784LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        if (S == "" || S == null) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }

    private void helper(char[] chs, List<String> list, int i){
        if (i == chs.length) {
            list.add(new String (chs));
            return;
        }

        if (chs[i] >= '0' && chs[i] <= '9'){
            helper(chs, list, i+ 1);
            return;
        }

        chs[i] = Character.toLowerCase(chs[i]);
        helper(chs, list, i + 1);

        chs[i] = Character.toUpperCase(chs[i]);
        helper(chs, list, i + 1);
    }
}
