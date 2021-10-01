package xyz.auriium.littlethings.conversation;

/**
 * Manager with extra functionality
 * @param <K>
 */
public interface SoftManager<K> {

    /**
     * Submit a conversation to the softmanager
     * @param owner the owner of the conversation
     * @param instance an instance of the conversation pattern to use
     * @param startEvent event to start with
     * @return whether it was successful or not
     */
    boolean submitStack(K owner, ConversationInstance instance, Object startEvent);

}
