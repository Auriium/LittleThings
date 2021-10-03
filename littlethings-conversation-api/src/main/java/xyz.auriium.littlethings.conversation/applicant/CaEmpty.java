package xyz.auriium.littlethings.conversation.applicant;

import xyz.auriium.littlethings.conversation.ConversationApplicant;
import xyz.auriium.littlethings.conversation.ConversationDirective;
import xyz.auriium.littlethings.conversation.RemapFunction;

import java.util.ArrayList;
import java.util.List;

public class CaEmpty implements ConversationApplicant {

    private final ConversationDirective directive;

    public CaEmpty(ConversationDirective directive) {
        this.directive = directive;
    }

    @Override
    public ConversationDirective directive() {
        return directive;
    }

    @Override
    public List<RemapFunction> remappings() {
        return new ArrayList<>();
    }
}
