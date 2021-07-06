package xyz.auriium.littlethings.optionals.fragment;

import xyz.auriium.littlethings.optionals.CoOptional;

import java.util.function.Consumer;

public interface MonoFragment<A> {

    <B> BiFragment<A,B> withPresent(CoOptional<B> optional);
    <B> MonoFragment<A> andPresent(CoOptional<B> optional);

    void ifPresent(Consumer<A> consumer);

}
