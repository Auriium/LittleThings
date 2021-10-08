package xyz.auriium.littlethings.collections;

import xyz.auriium.littlethings.collections.registry.Registry;
import xyz.auriium.littlethings.collections.registry.RegistryKey;
import xyz.auriium.littlethings.collections.registry.mutable.MrBase;
import xyz.auriium.littlethings.collections.registry.mutable.MutableRegistry;

public class RegistryInit {

    private final MutableRegistry delegate = new MrBase();

    public <T> RegistryInit init(RegistryKey<T> key, T value) {
        delegate.put(key, value);

        return this;
    }

    public Registry build() {
        return delegate; //TODO mutableCopy
    }

}
