package xyz.auriium.littlethings.optionals.impl;

import xyz.auriium.littlethings.optionals.fragment.MonoFragment;
import xyz.auriium.littlethings.optionals.CoOptional;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class StandardCoOptional<T> implements CoOptional<T> {

    private static final CoOptional<?> EMPTY = new StandardCoOptional<>(null);

    private final T value;

    public StandardCoOptional(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public boolean isPresent() {
        return value != null;
    }

    @Override
    public boolean isEmpty() {
        return value == null;
    }

    @Override
    public void ifPresent(Consumer<T> consumer) {
        if (value != null) {
            consumer.accept(value);
        }
    }

    @Override
    public void ifPresentElse(Consumer<T> consumer, Runnable or) {
        if (value != null) {
            consumer.accept(value);
        } else {
            or.run();
        }
    }

    @Override
    public T orElse(T or) {
        return value != null ? value : or;
    }

    @Override
    public T orElseGet(Supplier<T> supplier) {
        return value != null ? value : supplier.get();
    }

    @Override
    public T orElseThrow() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }

        return value;
    }

    @Override
    public <X extends Throwable> T orElseThrow(X throwable) throws Throwable {
        if (value == null) {
            throw throwable;
        }
        return value;
    }

    @Override
    public <X extends Throwable> T orElseThrow(Supplier<X> supplier) throws Throwable {
        if (value != null) {
            return value;
        } else {
            throw supplier.get();
        }
    }

    @Override
    public MonoFragment<T> split() {
        return null;
    }
}
