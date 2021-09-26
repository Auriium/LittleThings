package xyz.auriium.littlethings.conversation.simple;

import xyz.auriium.littlethings.conversation.simple.data.ConversationData;

public interface TypedConsumer<E> {

    ConversationResult onTypedEvent(E event, ConversationData data);

    class Fake<E> implements ConversationConsumer {

        private final TypedConsumer<E> consumer;
        private final Class<E> type;

        public Fake(TypedConsumer<E> consumer, Class<E> type) {
            this.consumer = consumer;
            this.type = type;
        }

        @Override
        public ConversationResult onEvent(Object event, ConversationData data) {
            if (!type.isInstance(event)) return ConversationResult.WAIT;

            return consumer.onTypedEvent((E) event, data);
        }
    }

}
