package xyz.auriium.littlethings.collections;

import java.util.ArrayList;
import java.util.List;

public class ListInit<T> {

    private final List<T> delegate = new ArrayList<>();

    public ListInit<T> init(T t) {
        delegate.add(t);

        return this;
    }

    public List<T> delegate() {
        return this.delegate;
    }

    public List<T> build() {
        return List.copyOf(delegate);
    }

}
