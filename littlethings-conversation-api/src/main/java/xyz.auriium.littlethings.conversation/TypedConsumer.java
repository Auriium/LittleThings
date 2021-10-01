package xyz.auriium.littlethings.conversation;

import xyz.auriium.littlethings.conversation.applicant.CaEmpty;

public interface TypedConsumer<E> {

    ConversationApplicant onTypedEvent(E event, ConversationData data);

    class Fake<E> implements ConversationConsumer {

        private final TypedConsumer<E> consumer;
        private final Class<E> type;

        public Fake(TypedConsumer<E> consumer, Class<E> type) {
            this.consumer = consumer;
            this.type = type;
        }

        @Override
        public ConversationApplicant onEvent(Object event, ConversationData data) {
            if (!type.isInstance(event)) return new CaEmpty(ConversationDirective.WAIT);

            return consumer.onTypedEvent((E) event, data);
        }
    }

}
