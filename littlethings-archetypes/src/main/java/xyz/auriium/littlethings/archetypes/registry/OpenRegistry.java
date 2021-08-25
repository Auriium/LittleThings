package xyz.auriium.littlethings.archetypes.registry;

public interface OpenRegistry<T> extends Registry<T> {

    OpenRegistry<T> insert(T value);

}
