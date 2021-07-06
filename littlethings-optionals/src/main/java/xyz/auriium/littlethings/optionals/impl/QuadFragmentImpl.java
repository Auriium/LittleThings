package xyz.auriium.littlethings.optionals.impl;

import xyz.auriium.littlethings.optionals.consumers.QuadConsumer;
import xyz.auriium.littlethings.optionals.fragment.QuadFragment;

import java.util.Optional;
import java.util.Set;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class QuadFragmentImpl<A,B,C,D> implements QuadFragment<A,B,C,D> {

    private final Set<Optional<?>> optionalSet;

    private final Optional<A> optionalA;
    private final Optional<B> optionalB;
    private final Optional<C> optionalC;
    private final Optional<D> optionalD;

    public QuadFragmentImpl(Set<Optional<?>> optionalSet, Optional<A> optionalA, Optional<B> optionalB, Optional<C> optionalC, Optional<D> optionalD) {
        this.optionalSet = optionalSet;
        this.optionalA = optionalA;
        this.optionalB = optionalB;
        this.optionalC = optionalC;
        this.optionalD = optionalD;
    }

    @Override
    public QuadFragment<A, B, C, D> andPresent(Optional<?> optional) {
        optionalSet.add(optional);

        return this;
    }

    @Override
    public void ifPresent(QuadConsumer<A, B, C, D> consumer) {
        for (Optional<?> optional : optionalSet) {
            if (optional.isEmpty()) return;
        }

        if (optionalA.isPresent() && optionalB.isPresent() && optionalC.isPresent() && optionalD.isPresent()) {
            consumer.accept(optionalA.get(),optionalB.get(),optionalC.get(),optionalD.get());
        }
    }
}
