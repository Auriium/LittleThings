package xyz.auriium.littlethings.conversation.simple;

public interface ConversationConsumer<D> {

    ConversationResult onEvent(Object event, D data);

}
