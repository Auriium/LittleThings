package xyz.auriium.littlethings.conversation.simple.manager.soft;

import xyz.auriium.littlethings.conversation.simple.instance.ConversationInstance;
import xyz.auriium.littlethings.conversation.simple.manager.ConversationManager;

import javax.management.InstanceAlreadyExistsException;

public class SmTryCatch<K> implements SoftManager<K> {

    private final ConversationManager<K> delegate;

    public SmTryCatch(ConversationManager<K> delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean submitStack(K owner, ConversationInstance instance) {
        try {
            delegate.submitStack(owner, instance);
            return true;
        } catch (InstanceAlreadyExistsException exception) {
            return false;
        }
    }
}
