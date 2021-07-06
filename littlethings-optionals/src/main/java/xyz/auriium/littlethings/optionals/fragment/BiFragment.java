package xyz.auriium.littlethings.optionals.fragment;

import xyz.auriium.littlethings.optionals.CoOptional;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface BiFragment<A,B> {

    <C> TriFragment<A,B,C> withPresent(CoOptional<C> optional);
    <C> BiFragment<A,B> andPresent(CoOptional<C> optional);

    void ifPresent(BiConsumer<A,B> consumer);

}
