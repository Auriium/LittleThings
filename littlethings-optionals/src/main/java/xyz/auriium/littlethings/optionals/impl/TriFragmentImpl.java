package xyz.auriium.littlethings.optionals.impl;

import xyz.auriium.littlethings.optionals.consumers.TriConsumer;
import xyz.auriium.littlethings.optionals.fragment.QuadFragment;
import xyz.auriium.littlethings.optionals.fragment.TriFragment;

import java.util.Optional;
import java.util.Set;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class TriFragmentImpl<A,B,C> implements TriFragment<A,B,C> {

    private final Set<Optional<?>> optionalSet;

    private final Optional<A> optionalA;
    private final Optional<B> optionalB;
    private final Optional<C> optionalC;

    public TriFragmentImpl(Set<Optional<?>> optionalSet, Optional<A> optionalA, Optional<B> optionalB, Optional<C> optionalC) {
        this.optionalSet = optionalSet;
        this.optionalA = optionalA;
        this.optionalB = optionalB;
        this.optionalC = optionalC;
    }


    @Override
    public <D> QuadFragment<A, B, C, D> withPresent(Optional<D> optional) {
        return new QuadFragmentImpl<>(optionalSet,optionalA,optionalB,optionalC,optional);
    }

    @Override
    public TriFragment<A, B, C> andPresent(Optional<?> optional) {
        optionalSet.add(optional);

        return this;
    }

    @Override
    public void ifPresent(TriConsumer<A, B, C> consumer) {
        for (Optional<?> optional : optionalSet) {
            if (optional.isEmpty()) return;
        }

        if (optionalA.isPresent() && optionalB.isPresent() && optionalC.isPresent()) {
            consumer.accept(optionalA.get(),optionalB.get(),optionalC.get());
        }
    }
}
