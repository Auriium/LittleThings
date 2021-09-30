package xyz.auriium.littlethings.conversation;

import xyz.auriium.littlethings.archetypes.closeables.KeyCloseable;

import javax.management.InstanceAlreadyExistsException;

public interface ConversationManager<K> extends KeyCloseable<K> {

    void submitEvent(K owner, Object event);
    void submitStack(K owner, ConversationInstance instance) throws InstanceAlreadyExistsException;

}
