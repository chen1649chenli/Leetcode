import java.util.HashMap;
import java.util.Map;

public class _146LRU {
    private class Node {
        Node prev;
        Node next;
        int key;
        int val;

        Node (int x, int y){
            this.key = x;
            this.val = y;
        }
    }

    private class DoubleLinkedList {
        Node sentinel;
        int size;

        DoubleLinkedList(){
            this.size = 0;
            sentinel = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
        }

        public void addLast(Node last){
            Node last_ = sentinel.prev;
            last_.next = last;
            last.next = sentinel;
            last.prev = last_;
            sentinel.prev = last;
            size += 1;
        }

        public void removeFirst(){
            Node node = sentinel.next;
            remove(node);
        }

        public int getFirstKey(){
            return sentinel.next.key;
        }

        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size -= 1;
        }
        public int size(){
            return this.size;
        }
    }

    int capacity;
    DoubleLinkedList list;
    Map<Integer, Node> cache;

    public _146LRU(int capacity) {
        this.capacity = capacity;
        list = new DoubleLinkedList();
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)){
            return -1;
        }else{
            Node node = cache.get(key);
            list.remove(node);
            list.addLast(node);
            return cache.get(key).val;
        }
    }

    public void put(int key, int value) {
        if(list.size() == capacity){
            if(cache.containsKey(key)){
                Node node = new Node(key, value);
                list.remove(cache.get(key));
                list.addLast(node);
                cache.put(key, node);
            }else{
                int i = list.getFirstKey();
                list.removeFirst();
                cache.remove(i);
                Node node = new Node(key, value);
                list.addLast(node);
                cache.put(key, node);
            }
        }else{
            if(cache.containsKey(key)){
                Node node = new Node(key, value);
                list.remove(cache.get(key));
                list.addLast(node);
                cache.put(key, node);
            }else{
                Node node = new Node(key, value);
                list.addLast(node);
                cache.put(key, node);
            }
        }
    }
}
