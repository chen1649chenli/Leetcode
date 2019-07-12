import java.util.Map;
import java.util.HashMap;

public class _953VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < order.length(); i += 1){
            dict.put(order.charAt(i), i);
        }
        int size = words.length;
        for (int j = 0; j < size -1; j += 1){
            boolean result = check(words[j], words[j + 1], dict);
            if (result == false){
                return false;
            }
        }
        return true;
    }

    public boolean check(String a, String b, Map<Character, Integer> map){
        int a_len = a.length();
        int b_len = b.length();
        int min_len = min(a_len, b_len);
        for (int k = 0; k < min_len; k += 1){
            if (map.get(a.charAt(k)) > map.get(b.charAt(k))){
                return false;
            } else if(map.get(a.charAt(k)) < map.get(b.charAt(k))){
                return true;
            } else{
                continue;
            }
        }
        if (a_len > b_len){
            return false;
        }
        return true;
    }

    public int min(int a, int b){
        return a < b ? a : b;
    }
}
