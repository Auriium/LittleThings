package xyz.auriium.littlethings.archetypes.closeables;

import java.io.Closeable;

public interface KeyCloseable<K> extends Closeable {

    void closeSingle(K key);

}
