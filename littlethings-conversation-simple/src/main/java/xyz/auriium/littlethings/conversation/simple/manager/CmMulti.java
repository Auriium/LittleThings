package xyz.auriium.littlethings.conversation.simple.manager;

import xyz.auriium.littlethings.conversation.simple.*;
import xyz.auriium.littlethings.conversation.simple.instance.ConversationInstance;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CmMulti<K> implements ConversationManager<K> {

    //require computeIfPresent atomicity guarantee
    private final ConcurrentMap<K, Collection<ConversationInstance>> map = new ConcurrentHashMap<>();

    @Override
    public void closeSingle(K key) {
        map.remove(key);
    }

    @Override
    public void close() {
        map.clear();
    }

    @Override
    public void submitEvent(K owner, Object event) {
        var stackCollection = map.get(owner);

        if (stackCollection == null) return;

        stackCollection.removeIf(stack -> stack.filter(event));
    }

    //fixme no support for identical objects
    @Override
    public void submitStack(K owner, ConversationInstance instance) {
        map.computeIfAbsent(owner, a -> new HashSet<>()).add(instance);

        submitEvent(owner, new StartSignal());
    }
}
