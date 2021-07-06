package xyz.auriium.littlethings.optionals.impl;

import xyz.auriium.littlethings.optionals.CoOptional;
import xyz.auriium.littlethings.optionals.fragment.MonoFragment;
import xyz.auriium.littlethings.optionals.fragment.BiFragment;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class MonoFragmentImpl<A> implements MonoFragment<A> {

    private final Set<CoOptional<?>> addionalOptionals;

    private final CoOptional<A> optionalA;

    public MonoFragmentImpl(Set<CoOptional<?>> addionalOptionals, CoOptional<A> optionalA) {
        this.addionalOptionals = addionalOptionals;
        this.optionalA = optionalA;
    }

    public MonoFragmentImpl(CoOptional<A> optionalA) {
        this.addionalOptionals = new HashSet<>();
        this.optionalA = optionalA;
    }


    @Override
    public <B> BiFragment<A, B> withPresent(CoOptional<B> optionalB) {
        return new BiFragmentImpl<>(addionalOptionals,optionalA,optionalB);
    }

    @Override
    public <B> MonoFragment<A> andPresent(CoOptional<B> optional) {
        addionalOptionals.add(optional);

        return this;
    }

    @Override
    public void ifPresent(Consumer<A> consumer) {
        for (CoOptional<?> optional : addionalOptionals) {
            if (optional.isEmpty()) return;
        }

        optionalA.ifPresent(consumer);
    }
}
