package xyz.auriium.littlethings.collections.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class DelegatingOptionalMap<T,V> implements OptionalMap<T,V> {

    protected final Map<T,V> delegate;

    public DelegatingOptionalMap(Map<T, V> delegate) {
        this.delegate = delegate;
    }

    public DelegatingOptionalMap() {
        this.delegate = new HashMap<>();
    }

    @Override
    public Optional<V> remove(T t) {
        return Optional.ofNullable(delegate.remove(t));
    }

    @Override
    public Optional<V> get(T t) {
        return Optional.ofNullable(delegate.get(t));
    }

    @Override
    public void removeIfPresent(T key, Consumer<V> consumer) {
        V e = delegate.remove(key);

        if (e != null) {
            consumer.accept(e);
        }
    }

    @Override
    public void consumeIfPresent(T key, Consumer<V> consumer) {
        V e = delegate.get(key);

        if (e != null) {
            consumer.accept(e);
        }
    }

    @Override
    public Map<T, V> delegate() {
        return delegate;
    }

    @Override
    public int size() {
        return delegate.size();
    }

}
