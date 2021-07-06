package xyz.auriium.littlethings.optionals;

import xyz.auriium.littlethings.optionals.fragment.MonoFragment;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Optional-like interface that also provides a builder module
 * @param <T> type of value stored
 */
public interface CoOptional<T> {

    /**
     * Gets the current value
     * @return the value or null if invalid
     */
    T get();

    /**
     * Gets whether the optional's stored value exists.
     * @return true if the value is present, false if not
     */
    boolean isPresent();

    /**
     * Gets whether the optional's stored value does not exist
     * @return true if the value is not present, false if not
     */
    boolean isEmpty();

    /**
     * Executes an action if the stored value s present
     * @param consumer the lambda to enact
     */
    void ifPresent(Consumer<T> consumer);

    /**
     * Executes a consumer if the stored value is present, and if not executes a runnable
     * @param consumer the consumer to enact if the value is present
     * @param or the runnable to enact if the value is not present
     */
    void ifPresentElse(Consumer<T> consumer, Runnable or);

    T orElse(T or);
    T orElseGet(Supplier<T> supplier);
    T orElseThrow();
    <X extends Throwable> T orElseThrow(X throwable) throws Throwable;
    <X extends Throwable> T orElseThrow(Supplier<X> supplier) throws Throwable;

    static <T> CoOptional<T> empty() {
        return null;
    }

    static <T> CoOptional<T> of(T value) {
        return null;
    }

    static <T> CoOptional<T> ofNullable(T value) {
        return null;
    }

}
