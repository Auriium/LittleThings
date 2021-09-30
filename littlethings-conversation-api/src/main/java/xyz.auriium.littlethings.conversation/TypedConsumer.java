package xyz.auriium.littlethings.conversation;

public interface TypedConsumer<E> {

    ConversationDirective onTypedEvent(E event, ConversationData data);

    class Fake<E> implements ConversationConsumer {

        private final TypedConsumer<E> consumer;
        private final Class<E> type;

        public Fake(TypedConsumer<E> consumer, Class<E> type) {
            this.consumer = consumer;
            this.type = type;
        }

        @Override
        public ConversationDirective onEvent(Object event, ConversationData data) {
            if (!type.isInstance(event)) return ConversationDirective.WAIT;

            return consumer.onTypedEvent((E) event, data);
        }
    }

}
