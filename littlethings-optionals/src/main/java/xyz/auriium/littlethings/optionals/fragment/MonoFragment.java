package xyz.auriium.littlethings.optionals.fragment;

import java.util.Optional;
import java.util.function.Consumer;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public interface MonoFragment<A> {

    <B> BiFragment<A,B> withPresent(Optional<B> optional);
    MonoFragment<A> andPresent(Optional<?> optional);

    void ifPresent(Consumer<A> consumer);

}
