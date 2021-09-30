package xyz.auriium.littlethings.conversation;

public interface SoftManager<K> {

    /**
     * Submit a conversation to the softmanager
     * @param owner the owner of the conversation
     * @param instance an instance of the conversation pattern to use
     * @return whether it was successful or not
     */
    boolean submitStack(K owner, ConversationInstance instance);

}
