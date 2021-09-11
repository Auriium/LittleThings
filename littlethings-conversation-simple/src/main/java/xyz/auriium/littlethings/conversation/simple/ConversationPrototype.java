package xyz.auriium.littlethings.conversation.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Supplier;

public class ConversationPrototype<D> {

    private final String identifier;
    private final Supplier<D> supplier;
    private final List<ConversationConsumer<D>> consumers = new ArrayList<>();

    ConversationPrototype(String identifier, Supplier<D> supplier) {
        this.identifier = identifier;
        this.supplier = supplier;
    }

    public ConversationPrototype<D> next(ConversationConsumer<D> consumer) {
        this.consumers.add(consumer);

        return this;
    }

    public <E> ConversationPrototype<D> next(Class<E> clazz, TypedConsumer<E,D> consumer) {
        this.consumers.add(new TypedConversationConsumer<>(clazz, consumer));

        return this;
    }

    public List<ConversationConsumer<D>> getConsumers() {
        return consumers;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Supplier<D> getSupplier() {
        return supplier;
    }

    public static <D> ConversationPrototype<D> make(String identifier, Supplier<D> dataObjectSupplier) {
        return new ConversationPrototype<>(identifier, dataObjectSupplier);
    }

    public ConversationInstance<D> make() {
        Queue<ConversationConsumer<D>> submit = new ConcurrentLinkedDeque<>();
        submit.add(new TypedConversationConsumer<>(StartSignal.class, (a,b) -> ConversationResult.NEXT));
        submit.addAll(consumers);

        return new ConversationInstance<>(identifier, submit, supplier.get());
    }

}
