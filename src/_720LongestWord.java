import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _720LongestWord {
    public String longestWord(String[] words) {
        public String longestWord(String[] words) {
            Set<String> set = new HashSet<>();
            Arrays.sort(words);
            String ans = "";
            for (String str: words){
                if (str.length() == 1 || set.contains(str.substring(0, str.length() - 1))){
                    set.add(str);
                    if (str.length() > ans.length()){
                        ans = str;
                    }
                }
            }
            return ans;
        }
    }
}
