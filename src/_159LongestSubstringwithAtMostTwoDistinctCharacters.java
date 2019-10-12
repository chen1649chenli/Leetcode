import java.util.HashMap;
import java.util.Map;

public class _159LongestSubstringwithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int start = 0, end = 0, len = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();

        while(end < s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > 2){
                char left = s.charAt(start);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                start += 1;
            }
            end += 1;
            len = Math.max(len, end - start);
        }
        return len;
    }
}
