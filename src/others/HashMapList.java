package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapList<T, E> {
    private final HashMap<T, ArrayList<E>> map = new HashMap<>();

    public void put(T key, E item) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(item);
    }

    public void put(T key, ArrayList<E> items) {
        map.put(key, items);
    }

    public ArrayList<E> get(T key) {
        return map.get(key);
    }

    public boolean containsKey(T key) {
        return map.containsKey(key);
    }

    public boolean containsKeyValue(T key, E item) {
        if (map.get(key) != null) {
            return map.get(key).contains(item);
        }
        return false;
    }

    public Set<T> keySet() {
        return map.keySet();
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
