import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _451SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character>[] bucket = new ArrayList[s.length() + 1];

        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            int id = entry.getValue();
            if (bucket[id] == null){
                bucket[id] = new ArrayList<>();
            }
            bucket[id].add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i >= 0; i -= 1){
            if (bucket[i] != null){
                List<Character> charList = bucket[i];
                for (char c: charList){
                    for (int j = 0; j < i; j += 1){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
