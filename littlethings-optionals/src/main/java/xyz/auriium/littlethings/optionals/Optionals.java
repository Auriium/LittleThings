package xyz.auriium.littlethings.optionals;

import xyz.auriium.littlethings.optionals.fragment.MonoFragment;
import xyz.auriium.littlethings.optionals.impl.MonoFragmentImpl;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class Optionals {

    public static <T> MonoFragment<T> baseFragment(Optional<T> optional) {
        return new MonoFragmentImpl<>(optional);
    }

}
