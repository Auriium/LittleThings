package xyz.auriium.littlethings.collections.registry;

public interface RegistryKey<T> {

    Class<T> keyType();
    String key();

}
