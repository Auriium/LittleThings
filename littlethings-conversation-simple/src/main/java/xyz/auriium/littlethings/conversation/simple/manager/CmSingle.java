package xyz.auriium.littlethings.conversation.simple.manager;

import xyz.auriium.littlethings.conversation.simple.instance.ConversationInstance;
import xyz.auriium.littlethings.conversation.simple.StartSignal;

import javax.management.InstanceAlreadyExistsException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CmSingle<K> implements ConversationManager<K> {

    private final ConcurrentMap<K, ConversationInstance> map = new ConcurrentHashMap<>();


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
        map.computeIfPresent(owner, (k,v) -> {
            if (v.filter(event)) {
                return null;
            }

            return v;
        });
    }

    @Override
    public void submitStack(K owner, ConversationInstance instance) throws InstanceAlreadyExistsException {
        if (map.containsKey(owner)) throw new InstanceAlreadyExistsException("already exists!");

        map.put(owner, instance);
        submitEvent(owner, new StartSignal());
    }
}
