package xyz.auriium.littlethings.collections.registry.mutable;

import xyz.auriium.littlethings.collections.registry.Registry;
import xyz.auriium.littlethings.collections.registry.RegistryKey;

public interface MutableRegistry extends Registry {

    /**
     * Inserts a value to the registry
     * @param key value
     * @param object object
     * @param <T> the object
     * @throws ClassCastException if key already exists in map under another type or if final cast fails.
     */
    <T> void put(RegistryKey<T> key, T object);

}
