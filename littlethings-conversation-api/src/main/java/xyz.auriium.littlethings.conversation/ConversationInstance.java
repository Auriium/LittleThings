package xyz.auriium.littlethings.conversation;

public interface ConversationInstance {

    boolean filter(Object event);
    ConversationData copy(); //get a copy of the data

}
