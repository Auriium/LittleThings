package xyz.auriium.littlethings.conversation.simple;

import xyz.auriium.littlethings.archetypes.closeables.KeyCloseable;

public interface ConversationManager<K,D> extends KeyCloseable<K> {

    void submitEvent(K owner, Object event);
    boolean submitStack(K owner, ConversationInstance<D> instance);

}
