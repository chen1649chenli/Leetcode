import java.util.*;

public class _127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        if (!dict.contains(endWord)) return 0;
        beginSet.add(beginWord);
        endSet.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);

        int step = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }

            Set<String> tmp = new HashSet<>();
            for (String word: beginSet){
                for (int i = 0; i < word.length(); i += 1){
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c += 1){
                        chars[i] = c;
                        String str = new String(chars);

                        if(endSet.contains(str)){
                            return step + 1;
                        }
                        if (!visited.contains(str) && dict.contains(str)){
                            tmp.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            step += 1;
            beginSet = tmp;
        }
        return 0;
    }
}
