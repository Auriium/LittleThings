package xyz.auriium.littlethings.conversation.simple.proto;

import xyz.auriium.littlethings.conversation.simple.instance.ConversationInstance;

public interface ConversationPrototype {

    ConversationInstance make();

    /*public ConversationInstance<D> make() {
        Queue<ConversationConsumer<D>> submit = new ConcurrentLinkedDeque<>();
        submit.add(new TypedConversationConsumer<>(StartSignal.class, (a,b) -> ConversationResult.NEXT));
        submit.addAll(consumers);

        return new ConversationInstance<>(identifier, submit, supplier.get());
    }*/

}
