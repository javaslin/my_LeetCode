import java.util.*;

public class LRUCache {

    private int capacity;

    private Map<Integer, Integer> map;

    private Stack<Integer> stack;


    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<>();
        this.stack = new Stack<>();
        this.capacity = capacity;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key);
        if (stack.contains(key)) {
            stack.removeElement(key);
            stack.push(key);
        }

        return value;
    }

    public void put(int key, int value) {

        if (stack.size() == capacity) {
            if (stack.contains(key)) {
                stack.removeElement(key);
                stack.push(key);
                map.put(key, value);
            } else {
                Integer k = stack.get(0);
                stack.remove(0);
                map.remove(k);
                map.put(key, value);
                stack.push(key);
            }
        } else if (stack.size() < capacity) {
            if (stack.contains(key)) {
                stack.removeElement(key);
                stack.push(key);
                map.put(key, value);
            } else {
                map.put(key, value);
                stack.push(key);
            }
        }


    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2, 6);
        lruCache.get(1);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }


}


