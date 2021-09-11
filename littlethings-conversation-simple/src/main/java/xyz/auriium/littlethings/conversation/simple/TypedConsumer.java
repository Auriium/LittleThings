package xyz.auriium.littlethings.conversation.simple;

public interface TypedConsumer<E,D> {

    ConversationResult onTypedEvent(E event, D data);

}
