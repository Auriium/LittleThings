package xyz.auriium.littlethings.conversation.simple.proto;

import xyz.auriium.littlethings.conversation.simple.ConversationConsumer;
import xyz.auriium.littlethings.conversation.simple.data.CdBase;
import xyz.auriium.littlethings.conversation.simple.instance.CiBase;
import xyz.auriium.littlethings.conversation.simple.instance.ConversationInstance;

import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CpFromArray implements ConversationPrototype {

    private final ConversationConsumer[] consumers;

    public CpFromArray(ConversationConsumer... consumers) {
        this.consumers = consumers;
    }

    @Override
    public ConversationInstance make() {
        return new CiBase(new ConcurrentLinkedQueue<>(Arrays.asList(consumers)),new CdBase());
    }
}
