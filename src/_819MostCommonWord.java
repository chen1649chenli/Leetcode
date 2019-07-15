import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _819MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> dict = new HashMap<>();
        Set<String> bannedList = new HashSet<>();
        for (String s : banned){
            bannedList.add(s);
        }
        String[] str = paragraph.replaceAll("[!?';,.]"," ").toLowerCase().split("\\s+");
        for (String s: str){
            if (!bannedList.contains(s)){
                dict.put(s, dict.getOrDefault(s, 0) + 1);
            }
        }
        return Collections.max(dict.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
