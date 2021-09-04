package xyz.auriium.littlethings.collections.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class DelegatingLinkMap<K,T,V> implements MultiLinkMap<K,T,V> {

    protected final Map<K, Map<T,V>> map;
    private final Supplier<Map<T,V>> newCol;

    public DelegatingLinkMap(Map<K, Map<T, V>> map, Supplier<Map<T, V>> newCol) {
        this.map = map;
        this.newCol = newCol;
    }

    public DelegatingLinkMap() {
        this.map = new HashMap<>();
        this.newCol = HashMap::new;
    }

    @Override
    public Map<K, Map<T, V>> delegate() {
        return map;
    }

    @Override
    public Optional<V> getByKey(K key, T key2) {
        return Optional.ofNullable(map.computeIfAbsent(key, s -> newCol.get()).get(key2));
    }

    @Override
    public V insert(K key, T key2, V value) {
        map.computeIfAbsent(key, s -> newCol.get()).computeIfAbsent(key2, s -> value);

        return value;
    }

    @Override
    public int size() {
        return map.size();
    }

}
