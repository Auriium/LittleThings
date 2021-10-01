package xyz.auriium.littlethings.conversation.applicant;

import xyz.auriium.littlethings.conversation.ConversationApplicant;
import xyz.auriium.littlethings.conversation.ConversationDirective;
import xyz.auriium.littlethings.conversation.RemapFunction;

import java.util.List;

public class CaWith implements ConversationApplicant {

    private final ConversationDirective directive;
    private final List<RemapFunction> remappings;

    public CaWith(ConversationDirective directive, List<RemapFunction> remappings) {
        this.directive = directive;
        this.remappings = remappings;
    }

    @Override
    public ConversationDirective directive() {
        return directive;
    }

    @Override
    public List<RemapFunction> remappings() {
        return remappings;
    }
}
