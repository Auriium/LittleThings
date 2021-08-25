package xyz.auriium.littlethings.collections.maps;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public interface OptionalMap<T,V> {

    Optional<V> remove(T t);

    Optional<V> get(T t);

    void removeIfPresent(T key, Consumer<V> consumer);

    void consumeIfPresent(T key, Consumer<V> consumer);

    Map<T,V> delegate();

    int size();

}
