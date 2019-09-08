import java.util.ArrayList;
import java.util.List;

public class _093RestoreIPAddressess {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 4 || s .length() > 12) return ans;
        backtrack(ans, s, 0, "", 0);
        return ans;
    }

    private void backtrack(List<String> ans, String s, int pos, String curr, int segment){
        if (segment > 4) return;
        if (segment == 4 && pos == s.length()){
            ans.add(curr);
            return;
        }

        for (int i = 1; i <= 3; i += 1){
            if (pos + i > s.length()) break;
            String section = s.substring(pos, pos + i);
            if (section.length() > 1 && section.startsWith("0") || Integer.parseInt(section) > 255) break;
            backtrack(ans, s, pos + i, segment == 0 ? section: curr + "." + section, segment + 1);
        }
    }
}
