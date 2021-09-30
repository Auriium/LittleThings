package xyz.auriium.littlethings.conversation;

public interface RemapFunction<K, V> {

    V remap(K key, V value);

}
