package xyz.auriium.littlethings.collections.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DelegatingLinkMap<K,T,V> implements MultiLinkMap<K,T,V> {

    protected final Map<K, Map<T,V>> map;

    public DelegatingLinkMap(Map<K,Map<T,V>> map) {
        this.map = map;
    }

    public DelegatingLinkMap() {
        this.map = new HashMap<>();
    }

    @Override
    public Map<K, Map<T, V>> delegate() {
        return map;
    }

    @Override
    public Optional<V> getByKey(K key, T key2) {
        return Optional.ofNullable(map.computeIfAbsent(key, s -> new HashMap<>()).get(key2));
    }

    @Override
    public V insert(K key, T key2, V value) {
        map.computeIfAbsent(key, s -> new HashMap<>()).computeIfAbsent(key2, s -> value);

        return value;
    }

    @Override
    public int size() {
        return map.size();
    }

}
