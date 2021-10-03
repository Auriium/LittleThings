package xyz.auriium.littlethings.conversation.simple.instance;

import xyz.auriium.littlethings.conversation.*;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public class CiBase implements ConversationInstance {

    private final Queue<ConversationConsumer> stages; //possible thread leakpoint, memory leakpoint
    private final AtomicReference<ConversationData> dataRef; //possible thread leakpoint

    public CiBase(Queue<ConversationConsumer> stages, ConversationData initialData) {
        this.stages = stages;
        this.dataRef = new AtomicReference<>(initialData);
    }


    @Override
    public boolean filter(Object event) {

        if (stages.isEmpty()) {
            return true;
        }

        ConversationConsumer stage = stages.peek();
        ConversationApplicant result = stage.onEvent(event, dataRef.get());

        //"""""wait""""" - or rather, cas loop, until we can remap our values with accuracy
        //this is to avoid blocking during thread contention, since as a direct extension of
        //event systems we do not want to hold up our fellow event subscribers.
        dataRef.updateAndGet(current -> current.remapped(result.remappings()));

        switch (result.directive()) {
            case CANCEL:
                return true;
            case NEXT:
                stages.remove();

                return stages.isEmpty();
            default:
                return false;
        }

    }

    //Is this dangerous? It isn't leaking data, it's returning a cloned object.
    @Override
    public ConversationData copy() {
        return dataRef.get().immutable(); //give us a copy!!!
    }
}
