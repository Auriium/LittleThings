package xyz.auriium.littlethings.optionals.impl;

import xyz.auriium.littlethings.optionals.CoOptional;
import xyz.auriium.littlethings.optionals.fragment.BiFragment;
import xyz.auriium.littlethings.optionals.fragment.TriFragment;

import java.util.Set;
import java.util.function.BiConsumer;

public class BiFragmentImpl<A,B> implements BiFragment<A,B> {

    private final Set<CoOptional<?>> addionalOptionals;

    private final CoOptional<A> originalA;
    private final CoOptional<B> originalB;

    public BiFragmentImpl(Set<CoOptional<?>> addionalOptionals, CoOptional<A> originalA, CoOptional<B> originalB) {
        this.addionalOptionals = addionalOptionals;
        this.originalA = originalA;
        this.originalB = originalB;
    }


    @Override
    public <C> TriFragment<A, B, C> withPresent(CoOptional<C> optional) {
        return null;
    }

    @Override
    public <C> BiFragment<A, B> andPresent(CoOptional<C> optional) {
        addionalOptionals.add(optional);

        return this;
    }

    @Override
    public void ifPresent(BiConsumer<A, B> consumer) {
        if (originalA.isPresent() && originalB.isPresent()) {
            consumer.accept(originalA.get(),originalB.get());
        }
    }
}
