package xyz.auriium.littlethings.collections;

import java.util.HashSet;
import java.util.Set;

public class SetInit<T> {

    private final Set<T> delegate = new HashSet<>();

    public SetInit<T> init(T t) {
        delegate.add(t);

        return this;
    }

    public Set<T> delegate() {
        return this.delegate;
    }

    public Set<T> build() {
        return Set.copyOf(delegate);
    }

}
