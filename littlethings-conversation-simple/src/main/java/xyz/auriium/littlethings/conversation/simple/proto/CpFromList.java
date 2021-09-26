package xyz.auriium.littlethings.conversation.simple.proto;

import xyz.auriium.littlethings.conversation.simple.ConversationConsumer;
import xyz.auriium.littlethings.conversation.simple.data.CdBase;
import xyz.auriium.littlethings.conversation.simple.instance.CiBase;
import xyz.auriium.littlethings.conversation.simple.instance.ConversationInstance;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CpFromList implements ConversationPrototype {

    private final List<ConversationConsumer> prototypes;

    public CpFromList(List<ConversationConsumer> prototypes) {
        this.prototypes = prototypes;
    }

    @Override
    public ConversationInstance make() {
        return new CiBase(new ConcurrentLinkedQueue<>(prototypes), new CdBase());
    }
}
