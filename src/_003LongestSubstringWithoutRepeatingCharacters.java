import java.util.HashSet;
import java.util.Set;

public class _003LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int ans = 1;
        for (int i = 0; i < s.length(); i += 1){
            Set<Character> uniqChar = new HashSet<>();
            uniqChar.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j += 1){
                if (!uniqChar.contains(s.charAt(j))){
                    uniqChar.add(s.charAt(j));
                    if (j - i + 1 > ans) ans = j - i + 1;
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}
