package xyz.auriium.littlethings.conversation.simple.proto;

import xyz.auriium.littlethings.conversation.ConversationConsumer;
import xyz.auriium.littlethings.conversation.ConversationData;
import xyz.auriium.littlethings.conversation.ConversationInstance;
import xyz.auriium.littlethings.conversation.ConversationPrototype;
import xyz.auriium.littlethings.conversation.simple.data.CdImmutable;
import xyz.auriium.littlethings.conversation.simple.data.CdNull;
import xyz.auriium.littlethings.conversation.simple.instance.CiBase;

import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Supplier;

public class CpFromArray implements ConversationPrototype {

    private final ConversationConsumer[] consumers;
    private final Supplier<ConversationData> dataSupplier;

    public CpFromArray(ConversationConsumer... consumers) {
        this.consumers = consumers;
        this.dataSupplier = () -> new CdNull(new CdImmutable());
    }

    public CpFromArray(ConversationConsumer[] consumers, Supplier<ConversationData> dataSupplier) {
        this.consumers = consumers;
        this.dataSupplier = dataSupplier;
    }

    @Override
    public ConversationInstance make() {
        return new CiBase(new ConcurrentLinkedQueue<>(Arrays.asList(consumers)),dataSupplier.get());
    }
}
