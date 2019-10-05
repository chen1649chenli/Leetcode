import java.util.ArrayList;
import java.util.List;

public class _483FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return ans;
        int[] hash = new int[256];
        for (char c : p.toCharArray()){
            hash[c] += 1;
        }
        int lo = 0, hi = 0, count = 0, len = s.length();
        while(hi < len){
            if (hash[s.charAt(hi)] > 0){
                hash[s.charAt(hi)] -= 1;
                hi += 1;
                count += 1;
            }else{
                hash[s.charAt(hi)] += 1;
                lo += 1;
                count -= 1;
            }
            if (count == p.length()){
                ans.add(lo);
            }
        }
        return ans;
    }
}
