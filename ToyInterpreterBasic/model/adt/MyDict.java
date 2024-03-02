package model.adt;

import java.util.HashMap;
import java.util.Map;
import exceptions.ADTException;

public class MyDict<K, V> implements MyIDict<K, V> {
    private Map<K, V> map;

    public MyDict() {
        map = new HashMap<K, V>();
    }

    @Override
    public void put(K k, V v) throws ADTException {
        if (map.containsKey(k))
            throw new ADTException("Element already defined");
        map.put(k, v);
    }

    @Override
    public boolean isDefined(K k) {
        return map.get(k) != null;
    }

    @Override
    public V lookUp(K k) {
        return map.get(k);
    }

    public Map<K, V> getMap() {
        return map;
    }

    public void setMap(Map<K, V> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (K key : map.keySet())
            result.append(key.toString()).append("->").append(map.get(key).toString()).append("\n");
        if (result.length() > 0)
            result.deleteCharAt(result.length() - 1);
        return "[map=" + result + "]";
        // edit?
    }

    @Override
    public void update(K k, V newV) throws ADTException {
        if (!map.containsKey(k))
            throw new ADTException("Element doesn't exist");

        this.map.replace(k, newV);
    }

}
