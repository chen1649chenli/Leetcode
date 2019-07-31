import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _146LRU {
    int capacity;
    LinkedList<Integer> list;
    Map<Integer, Integer> map;

    public _146LRU(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        list.remove(Integer.valueOf(key));
        list.add(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            list.remove(Integer.valueOf(key));
            list.addLast(key);
        }else{
            if (list.size() == capacity){
                int i = list.removeFirst();
                list.addLast(key);
                map.remove(i);
            }else{
                list.addLast(key);
            }
        }
        map.put(key, value);
    }
}
