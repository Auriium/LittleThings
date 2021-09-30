package xyz.auriium.littlethings.conversation.simple.manager;

import xyz.auriium.littlethings.conversation.ConversationInstance;
import xyz.auriium.littlethings.conversation.ConversationManager;

import javax.management.InstanceAlreadyExistsException;
import java.util.concurrent.ConcurrentHashMap;

public class CmSingle<K> implements ConversationManager<K> {

    //require computeIfPresent atomicity guarantee
    private final ConcurrentHashMap<K, ConversationInstance> map;

    public CmSingle() {
        this.map = new ConcurrentHashMap<>();
    }

    public CmSingle(ConcurrentHashMap<K, ConversationInstance> map) {
        this.map = map;
    }

    @Override
    public void submitEvent(K owner, Object event) {
        map.computeIfPresent(owner, (k,v) -> {
            //apparently threadsafe? thanks java
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
    }

    @Override
    public void closeSingle(K key) {
        map.remove(key);
    }

    @Override
    public void close() {
        map.clear();
    }
}
