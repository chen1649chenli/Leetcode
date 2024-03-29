import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _170TwoSumIII {
    /** Initialize your data structure here. */
    Map<Integer, Integer> map;
    public _170TwoSumIII() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i : map.keySet()){
            if (map.containsKey(value -i)){
                if (i != value - i || map.get(i) >= 2) return true;
            }
        }
        return false;
    }
}
