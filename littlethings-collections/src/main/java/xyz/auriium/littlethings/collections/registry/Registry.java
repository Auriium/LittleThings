package xyz.auriium.littlethings.collections.registry;

import java.util.Map;

public interface Registry {

    /**
     * Gets a registry value by key
     * @param key the key
     * @param <T> the type
     * @return the value
     * @throws ClassCastException if value in registry is of a different type than specified by key
     * @throws IllegalStateException if value is not present
     */
    <T> T get(RkDefault<T> key);

}
