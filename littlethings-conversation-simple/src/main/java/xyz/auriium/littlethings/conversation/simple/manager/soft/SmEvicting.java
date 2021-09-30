package xyz.auriium.littlethings.conversation.simple.manager.soft;

import xyz.auriium.littlethings.conversation.ConversationInstance;
import xyz.auriium.littlethings.conversation.ConversationManager;
import xyz.auriium.littlethings.conversation.SoftManager;

import javax.management.InstanceAlreadyExistsException;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;

public class SmEvicting<K> implements SoftManager<K> {

    private final ConversationManager<K> manager;
    private final Executor service;
    private final BiConsumer<K, ConversationInstance> eviction;

    public SmEvicting(ConversationManager<K> manager, Executor service, BiConsumer<K, ConversationInstance> eviction) {
        this.manager = manager;
        this.service = service;
        this.eviction = eviction;
    }

    public SmEvicting(ConversationManager<K> delegate, Executor service) {
        this.manager = delegate;
        this.service = service;
        this.eviction = (a,b) -> {};
    }

    @Override
    public boolean submitStack(K owner, ConversationInstance instance) {

        try {
            manager.submitStack(owner, instance);
        } catch (InstanceAlreadyExistsException exception) {
            return false;
        }

        service.execute(() -> {
            eviction.accept(owner, instance);

            manager.closeSingle(owner);
        });

        return true;
    }
}
