import java.util.HashMap;
import java.util.Map;
import static java.lang.Math.min;

public class _387FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        Map<Character, Integer> position = new HashMap();
        for (int i = 0; i < s.length(); i += 1){
            if(position.containsKey(s.charAt(i))){
                position.put(s.charAt(i), -1);
            }else{
                position.put(s.charAt(i), i);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < s.length(); j += 1){
            if (position.get(s.charAt(j)) != -1){
                result = min(result, position.get(s.charAt(j)));
            }
        }

        if (result < Integer.MAX_VALUE){
            return result;
        }else{
            return -1;
        }
    }
    public int min(int a, int b){
        return a < b ? a : b;
    }
}
