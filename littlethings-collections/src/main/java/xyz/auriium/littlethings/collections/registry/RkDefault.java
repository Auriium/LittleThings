package xyz.auriium.littlethings.collections.registry;

public class RkDefault<T> implements RegistryKey<T> {

    private final Class<T> keyType;
    private final String key;

    public RkDefault(Class<T> keyType, String key) {
        this.keyType = keyType;
        this.key = key;
    }

    @Override
    public Class<T> keyType() {
        return keyType;
    }

    @Override
    public String key() {
        return key;
    }
}
