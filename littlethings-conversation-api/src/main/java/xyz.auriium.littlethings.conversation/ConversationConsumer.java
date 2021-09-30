package xyz.auriium.littlethings.conversation;

public interface ConversationConsumer {

    ConversationDirective onEvent(Object event, ConversationData data);

}
