package xyz.auriium.littlethings.optionals.fragment;

import xyz.auriium.littlethings.optionals.consumers.QuadConsumer;

import java.util.Optional;
@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public interface QuadFragment<A,B,C,D> {

    QuadFragment<A,B,C,D> andPresent(Optional<?> optional);


    void ifPresent(QuadConsumer<A,B,C,D> consumer);

}
