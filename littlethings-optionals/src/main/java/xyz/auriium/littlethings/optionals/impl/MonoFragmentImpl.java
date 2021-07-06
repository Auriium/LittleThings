package xyz.auriium.littlethings.optionals.impl;

import xyz.auriium.littlethings.optionals.fragment.MonoFragment;
import xyz.auriium.littlethings.optionals.fragment.BiFragment;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class MonoFragmentImpl<A> implements MonoFragment<A> {

    private final Set<Optional<?>> addionalOptionals;

    private final Optional<A> optionalA;

    public MonoFragmentImpl(Set<Optional<?>> addionalOptionals, Optional<A> optionalA) {
        this.addionalOptionals = addionalOptionals;
        this.optionalA = optionalA;
    }

    public MonoFragmentImpl(Optional<A> optionalA) {
        this.addionalOptionals = new HashSet<Optional<?>>();
        this.optionalA = optionalA;
    }


    @Override
    public <B> BiFragment<A, B> withPresent(Optional<B> optionalB) {
        return new BiFragmentImpl<>(addionalOptionals,optionalA,optionalB);
    }

    @Override
    public MonoFragment<A> andPresent(Optional<?> optional) {
        addionalOptionals.add(optional);

        return this;
    }

    @Override
    public void ifPresent(Consumer<A> consumer) {
        for (Optional<?> optional : addionalOptionals) {
            if (optional.isEmpty()) return;
        }

        optionalA.ifPresent(consumer);
    }
}
