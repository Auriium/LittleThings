package xyz.auriium.littlethings.collections.maps;

import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;

public interface MultiMap<T,V> {

    Map<T, Collection<V>> getDelegate();

    /**
     * Gets a ollection mapped to the key
     * @param key the key
     * @return the collection
     */
    Collection<V> get(T key);

    /**
     * Gets a collection mapped to the key and removes the collection from the map
     * @param key the key
     * @return collection
     */
    Collection<V> remove(T key);

    /**
     * Inserts an object into the map
     * @param t key
     * @param v value
     */
    void insert(T t, V v);

    /**
     * Inserts a collection of values into the map
     * @param t key
     * @param v value
     */
    void insertAll(T t, Collection<V> v);

    /**
     * Replaces a collection of values mapped to a key
     * @param t key
     * @param v value
     */
    void replaceAll(T t, Collection<V> v);

    void forEach(T key, Consumer<V> consumer);
    void forEvery(Consumer<V> consumer);

    int size();

}
