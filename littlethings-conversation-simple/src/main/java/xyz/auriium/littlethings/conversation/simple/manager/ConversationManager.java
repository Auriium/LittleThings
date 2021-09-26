package xyz.auriium.littlethings.conversation.simple.manager;

import xyz.auriium.littlethings.archetypes.closeables.KeyCloseable;
import xyz.auriium.littlethings.conversation.simple.instance.ConversationInstance;

import javax.management.InstanceAlreadyExistsException;

public interface ConversationManager<K> extends KeyCloseable<K> {

    void submitEvent(K owner, Object event);
    void submitStack(K owner, ConversationInstance instance) throws InstanceAlreadyExistsException;

}
