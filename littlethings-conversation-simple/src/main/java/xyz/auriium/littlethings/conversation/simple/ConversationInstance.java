package xyz.auriium.littlethings.conversation.simple;

import java.util.Queue;

public class ConversationInstance<D> {

    private final String conversationID;
    private final Queue<ConversationConsumer<D>> stages;
    private final D data;

    ConversationInstance(String conversationID, Queue<ConversationConsumer<D>> stages, D data) {
        this.conversationID = conversationID;
        this.stages = stages;
        this.data = data;
    }

    public String id() {
        return conversationID;
    }

    public Queue<ConversationConsumer<D>> stages() {
        return stages;
    }

    public D data() {
        return data;
    }
}
