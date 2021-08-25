package xyz.auriium.littlethings.archetypes.closeables;

import java.io.Closeable;

public interface KeyCloseable<K> {

    void closeSingle(K key);
    void close();

}
