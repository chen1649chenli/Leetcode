import java.util.ArrayList;
import java.util.List;

public class _131PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.length() == 0) return ans;

        int strlen = s.length();

        backtrack(ans, new ArrayList<>(), s, 1, 0, strlen);
        return ans;
    }

    private void backtrack(List<List<String>> ans, List<String> list, String s, int start, int end, int len){
        if (end == len){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= len; i += 1){
            String tmp = s.substring(end, i);
            if (isPalindrome(tmp)){
                list.add(tmp);
                backtrack(ans, list, s, i + 1, i, len);
            }else{
                continue;
            }
            list.remove(list.size() - 1);
        }
    }

    private boolean isPalindrome(String s){
        int h = s.length() - 1;
        int l = 0;
        while(l < h){
            if (s.charAt(l) != s.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }
}
