import java.util.HashSet;
import java.util.Set;

public class _003LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int slow = 0, quick = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while(quick < s.length()){
            if (!set.contains(s.charAt(quick))){
                set.add(s.charAt(quick));
                quick += 1;
                max = Math.max(max, quick - slow);
            }else{
                set.remove(s.charAt(slow++));
            }
        }
        return max;
    }
}
