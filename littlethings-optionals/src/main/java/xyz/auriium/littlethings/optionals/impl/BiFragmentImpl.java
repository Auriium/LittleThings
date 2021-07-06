package xyz.auriium.littlethings.optionals.impl;

import xyz.auriium.littlethings.optionals.fragment.BiFragment;
import xyz.auriium.littlethings.optionals.fragment.TriFragment;

import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class BiFragmentImpl<A,B> implements BiFragment<A,B> {

    private final Set<Optional<?>> addionalOptionals;

    private final Optional<A> originalA;
    private final Optional<B> originalB;

    public BiFragmentImpl(Set<Optional<?>> addionalOptionals, Optional<A> originalA, Optional<B> originalB) {
        this.addionalOptionals = addionalOptionals;
        this.originalA = originalA;
        this.originalB = originalB;
    }


    @Override
    public <C> TriFragment<A, B, C> withPresent(Optional<C> optional) {
        return new TriFragmentImpl<>(addionalOptionals,originalA,originalB,optional);
    }

    @Override
    public BiFragment<A, B> andPresent(Optional<?> optional) {
        addionalOptionals.add(optional);

        return this;
    }

    @Override
    public void ifPresent(BiConsumer<A, B> consumer) {
        for (Optional<?> optional : addionalOptionals) {
            if (optional.isEmpty()) return;
        }

        if (originalA.isPresent() && originalB.isPresent()) {
            consumer.accept(originalA.get(),originalB.get());
        }
    }
}
