package xyz.auriium.littlethings.conversation.simple.instance;

import xyz.auriium.littlethings.conversation.ConversationConsumer;
import xyz.auriium.littlethings.conversation.ConversationData;
import xyz.auriium.littlethings.conversation.ConversationInstance;
import xyz.auriium.littlethings.conversation.ConversationDirective;

import java.util.Queue;

public class CiBase implements ConversationInstance {

    private final Queue<ConversationConsumer> stages;
    private final ConversationData data;

    public CiBase(Queue<ConversationConsumer> stages, ConversationData data) {
        this.stages = stages;
        this.data = data;
    }

    @Override
    public boolean filter(Object event) {
        if (stages.isEmpty()) {
            return true;
        }

        ConversationConsumer stage = stages.peek();

        ConversationDirective result = stage.onEvent(event, data);
        switch (result) {
            case CANCEL:
                return true;
            case NEXT:
                stages.remove();

                return stages.isEmpty();
            default: return false;
        }
    }
}
