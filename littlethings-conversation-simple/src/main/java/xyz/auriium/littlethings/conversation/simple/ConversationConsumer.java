package xyz.auriium.littlethings.conversation.simple;

import xyz.auriium.littlethings.conversation.simple.data.ConversationData;

public interface ConversationConsumer {

    ConversationResult onEvent(Object event, ConversationData data);

}
