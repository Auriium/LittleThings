package xyz.auriium.littlethings.archetypes.registry;

public interface Registry<T> {

    <V extends T> V retrieve(Class<V> value);

}
