import java.util.HashMap;
import java.util.Map;

public class _076MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        Map<Character, Integer> dict = new HashMap<>();
        for (char c: t.toCharArray()){
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }
        int count = dict.size();
        int len = Integer.MAX_VALUE;
        int start = 0, end = 0, head = -1;
        while(end < s.length()){
            char tmp = s.charAt(end);
            if (dict.containsKey(tmp)){
                dict.put(tmp, dict.get(tmp) - 1);
                if (dict.get(tmp) == 0) count -= 1;
            }
            end += 1;

            while(count == 0){
                char left = s.charAt(start);
                if (len > end - start){
                    len = end - start;
                    head = start;
                }

                if (dict.containsKey(left)){
                    dict.put(left, dict.get(left) + 1);
                    if (dict.get(left) > 0) count += 1;
                }
                start += 1;
            }
        }
        if (head == -1) return "";
        return s.substring(head, head + len);
    }
}
