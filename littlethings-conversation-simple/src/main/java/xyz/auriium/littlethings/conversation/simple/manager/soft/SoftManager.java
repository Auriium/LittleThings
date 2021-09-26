package xyz.auriium.littlethings.conversation.simple.manager.soft;

import xyz.auriium.littlethings.conversation.simple.instance.ConversationInstance;

public interface SoftManager<K> {

    /**
     * wrap
     * @param owner owner
     * @param instance instance
     * @return whether it was successful or not
     */
    boolean submitStack(K owner, ConversationInstance instance);

}
