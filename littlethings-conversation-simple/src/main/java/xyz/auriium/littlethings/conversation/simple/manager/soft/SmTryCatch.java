package xyz.auriium.littlethings.conversation.simple.manager.soft;
import xyz.auriium.littlethings.conversation.ConversationInstance;
import xyz.auriium.littlethings.conversation.ConversationManager;
import xyz.auriium.littlethings.conversation.SoftManager;

import javax.management.InstanceAlreadyExistsException;
import java.util.concurrent.TimeUnit;

public class SmTryCatch<K> implements SoftManager<K> {

    private final ConversationManager<K> delegate;

    public SmTryCatch(ConversationManager<K> delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean submitStack(K owner, ConversationInstance instance, Object object) {
        try {
            delegate.submitStack(owner, instance);
            delegate.submitEvent(owner, object);
            return true;
        } catch (InstanceAlreadyExistsException exception) {
            return false;
        }


    }
}
