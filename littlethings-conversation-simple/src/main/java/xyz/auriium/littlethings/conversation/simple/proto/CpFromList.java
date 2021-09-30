package xyz.auriium.littlethings.conversation.simple.proto;

import xyz.auriium.littlethings.conversation.ConversationConsumer;
import xyz.auriium.littlethings.conversation.ConversationPrototype;
import xyz.auriium.littlethings.conversation.simple.data.CdBase;
import xyz.auriium.littlethings.conversation.ConversationData;
import xyz.auriium.littlethings.conversation.simple.data.CdNull;
import xyz.auriium.littlethings.conversation.simple.instance.CiBase;
import xyz.auriium.littlethings.conversation.ConversationInstance;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Supplier;

public class CpFromList implements ConversationPrototype {

    private final List<ConversationConsumer> prototypes;
    private final Supplier<ConversationData> dataSupplier;

    public CpFromList(List<ConversationConsumer> prototypes) {
        this.prototypes = prototypes;
        this.dataSupplier = () -> new CdNull(new CdBase());
    }

    public CpFromList(List<ConversationConsumer> prototypes, Supplier<ConversationData> dataSupplier) {
        this.prototypes = prototypes;
        this.dataSupplier = dataSupplier;
    }

    @Override
    public ConversationInstance make() {
        return new CiBase(new ConcurrentLinkedQueue<>(prototypes), dataSupplier.get());
    }
}
