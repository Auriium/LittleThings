package xyz.auriium.littlethings.conversation.simple.instance;

import xyz.auriium.littlethings.conversation.simple.ConversationConsumer;
import xyz.auriium.littlethings.conversation.simple.ConversationResult;
import xyz.auriium.littlethings.conversation.simple.data.ConversationData;

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

        ConversationResult result = stage.onEvent(event, data);
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
