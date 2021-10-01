package xyz.auriium.littlethings.conversation;

import java.util.List;

//toremove since it's a data transfer object and does nothing useful with this data
public interface ConversationApplicant {

    ConversationDirective directive();
    List<RemapFunction> remappings();
}
