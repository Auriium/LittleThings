package xyz.auriium.littlethings.conversation.simple.manager;

import xyz.auriium.littlethings.conversation.ConversationInstance;
import xyz.auriium.littlethings.conversation.ConversationManager;

import javax.management.InstanceAlreadyExistsException;
import java.util.function.Supplier;

/**
 * ConversationManager decorator that sends a customizable start signal once a stack is submitted
 * For when you don't care about softmanager
 * @param <K> key
 */
public class CmStartSignal<K> implements ConversationManager<K> {

    private final ConversationManager<K> delegate;
    private final Supplier<Object> startSignal;

    public CmStartSignal(ConversationManager<K> delegate) {
        this.delegate = delegate;
        this.startSignal = StartSignal::new;
    }

    public CmStartSignal(ConversationManager<K> delegate, Supplier<Object> startSignal) {
        this.delegate = delegate;
        this.startSignal = startSignal;
    }

    @Override
    public void submitEvent(K owner, Object event) {
        delegate.submitEvent(owner, event);
    }

    @Override
    public void submitStack(K owner, ConversationInstance instance) throws InstanceAlreadyExistsException {
        delegate.submitStack(owner, instance);

        submitEvent(owner, startSignal.get());
    }

    @Override
    public void closeSingle(K key) {
        delegate.closeSingle(key);
    }

    @Override
    public void close() {
        delegate.close();
    }
}
