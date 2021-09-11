package xyz.auriium.littlethings.conversation.simple.impl;

import xyz.auriium.littlethings.conversation.simple.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConversationManagerImpl<K,D> implements ConversationManager<K,D> {

    private final ConcurrentMap<K, Collection<ConversationInstance<D>>> map = new ConcurrentHashMap<>();

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

        boolean removed = stackCollection.removeIf(stack -> {
            Queue<ConversationConsumer<D>> stages = stack.stages();

            if (stages.isEmpty()) {
                return true;
            }

            ConversationConsumer<D> stage = stages.peek();

            ConversationResult result = stage.onEvent(event, stack.data());
            switch (result) {
                case CANCEL:
                    return true;
                case NEXT:
                    stages.remove();

                    return stages.isEmpty();
                default: return false;
            }
        });

    }

    @Override
    public boolean submitStack(K owner, ConversationInstance<D> instance) {
        Collection<ConversationInstance<D>> stacks;
        if ((stacks = map.get(owner)) != null) {
            for (ConversationInstance<D> stack : stacks) {
                if (stack.id().equals(instance.id())) {
                    return false;
                }
            }
        } else {
            stacks = map.computeIfAbsent(owner, a -> new HashSet<>());
        }

        stacks.add(instance);
        submitEvent(owner, new StartSignal());

        return true;
    }
}
