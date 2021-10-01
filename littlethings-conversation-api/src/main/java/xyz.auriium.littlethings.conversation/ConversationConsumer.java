package xyz.auriium.littlethings.conversation;

public interface ConversationConsumer {

    ConversationApplicant onEvent(Object event, ConversationData data);

}
