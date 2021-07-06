package xyz.auriium.littlethings.optionals.fragment;

import java.util.Optional;
import java.util.function.BiConsumer;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public interface BiFragment<A,B> {

    <C> TriFragment<A,B,C> withPresent(Optional<C> optional);
    BiFragment<A,B> andPresent(Optional<?> optional);

    void ifPresent(BiConsumer<A,B> consumer);

}
