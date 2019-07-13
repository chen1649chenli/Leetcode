import java.util.HashMap;
import java.util.Map;

public class _013RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);

        int sum = 0;
        char prev = '&';
        int size = s.length();
        for (int i = size - 1; i >= 0; i -= 1){
            int value = dict.get(s.charAt(i));
            if (value < sum && prev != s.charAt(i)){
                sum = sum - value;
            }else {
                sum += value;
            }
            prev = s.charAt(i);
        }

        return sum;
    }
}
