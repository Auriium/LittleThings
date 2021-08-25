package xyz.auriium.littlethings.collections;

import java.util.HashMap;
import java.util.Map;

public class MapInit<K,V> {

    private final Map<K,V> delegate = new HashMap<>();

    public MapInit<K,V> init(K k, V v) {
        this.delegate.put(k,v);
        return this;
    }

    public Map<K,V> delegate() {
        return this.delegate;
    }

    public Map<K,V> build() {
        return Map.copyOf(delegate);
    }

}
