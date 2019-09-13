import java.util.List;

public class _139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, wordDict, new boolean[s.length()]);
    }

    private boolean wordBreak(String s, int from, List<String> dict, boolean[] cache) {
        if(from == s.length()) return true;
        if(from > s.length() || cache[from]) return false;
        for(int i=0; i < dict.size(); i++) {
            final String word = dict.get(i);
            if(s.startsWith(word, from) && wordBreak(s, from + word.length(), dict, cache)) {
                return true;
            }
        }
        cache[from] = true;
        return false;
    }
}
