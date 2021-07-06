package xyz.auriium.littlethings.optionals.fragment;

import xyz.auriium.littlethings.optionals.consumers.TriConsumer;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public interface TriFragment<A,B,C> {

    <D> QuadFragment<A,B,C,D> withPresent(Optional<D> optional);
    TriFragment<A,B,C> andPresent(Optional<?> optional);

    void ifPresent(TriConsumer<A,B,C> consumer);
}
