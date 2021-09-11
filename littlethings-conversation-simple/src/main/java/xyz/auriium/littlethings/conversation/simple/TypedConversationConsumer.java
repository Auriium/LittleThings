package xyz.auriium.littlethings.conversation.simple;

public class TypedConversationConsumer<E,D> implements ConversationConsumer<D> {

    private final Class<E> eventClass;
    private final TypedConsumer<E,D> consumer;

    public TypedConversationConsumer(Class<E> eventClass, TypedConsumer<E, D> consumer) {
        this.eventClass = eventClass;
        this.consumer = consumer;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final ConversationResult onEvent(Object event, D data) {
        if (eventClass.isInstance(event)) return ConversationResult.WAIT;

        return consumer.onTypedEvent((E) event, data);
    }

}
