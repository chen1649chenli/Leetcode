import java.util.*;

public class _380GetRandomO1 {
    Map<Integer, Integer> map;
    List<Integer> list;
    /** Initialize your data structure here. */
    public _380GetRandomO1() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }else{
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val);
        int lastIndex = list.size() - 1;
        int swap = list.get(lastIndex);
        if (lastIndex == idx){
            list.remove(lastIndex);
            map.remove(val);
        }else{
            list.remove(lastIndex);
            list.set(idx, swap);
            map.remove(val);
            map.put(swap, idx);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int size = list.size();
        Random rn = new Random();
        int idx = rn.nextInt(size);
        return list.get(idx);
    }
}
