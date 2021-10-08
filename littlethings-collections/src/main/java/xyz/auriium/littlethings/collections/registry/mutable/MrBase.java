package xyz.auriium.littlethings.collections.registry.mutable;

import xyz.auriium.littlethings.collections.registry.RegistryKey;
import xyz.auriium.littlethings.collections.registry.RkDefault;

import java.util.HashMap;
import java.util.Map;

public class MrBase implements MutableRegistry {

    private final Map<String, Object> map = new HashMap<>();

    @Override
    public <T> T get(RkDefault<T> key) {
        Object nullable = map.get(key.key());

        if (nullable == null) throw new IllegalStateException("No value present for key: " + key);

        return key.keyType().cast(nullable);
    }

    @Override
    public <T> void put(RegistryKey<T> key, T object) {

        Object nullable;

        if ((nullable = map.get(key.key())) != null && !key.keyType().isInstance(nullable)) throw new ClassCastException();

        map.put(key.key(), key.keyType().cast(object));
    }
}
