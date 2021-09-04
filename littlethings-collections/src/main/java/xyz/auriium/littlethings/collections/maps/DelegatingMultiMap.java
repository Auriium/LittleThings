package xyz.auriium.littlethings.collections.maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DelegatingMultiMap<T,V> implements MultiMap<T,V> {

    protected final Map<T, Collection<V>> map;
    private final Supplier<Collection<V>> newCol;

    public DelegatingMultiMap(Map<T, Collection<V>> map, Supplier<Collection<V>> newCol) {
        this.map = map;
        this.newCol = newCol;
    }


    public DelegatingMultiMap() {
        this.map = new HashMap<>();
        this.newCol = HashSet::new;
    }

    @Override
    public Map<T, Collection<V>> getDelegate() {
        return map;
    }

    @Override
    public Collection<V> get(T key) {
        return map.get(key);
    }

    @Override
    public Collection<V> remove(T key) {
        return map.remove(key);
    }

    @Override
    public void replaceAll(T t, Collection<V> v) {
        map.put(t,v);
    }

    @Override
    public void forEach(T key, Consumer<V> consumer) {
        Collection<V> col = map.get(key);

        if (col != null) {
            for(V v : col) {
                consumer.accept(v);
            }
        }
    }

    @Override
    public void forEvery(Consumer<V> consumer) {
        map.forEach((k,v) -> v.forEach(consumer));
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void insert(T t, V v) {
        map.computeIfAbsent(t, ignored -> newCol.get()).add(v);
    }

    @Override
    public void insertAll(T t, Collection<V> v) {
        map.computeIfAbsent(t, ignored -> newCol.get()).addAll(v);
    }

}
