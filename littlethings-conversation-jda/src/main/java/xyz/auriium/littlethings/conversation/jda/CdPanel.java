package xyz.auriium.littlethings.conversation.jda;

import xyz.auriium.littlethings.conversation.ConversationData;

public class CdPanel implements ConversationData {

    private final ConversationData delegate;
    private final Panel panel;

    public CdPanel(ConversationData delegate, Panel panel) {
        this.delegate = delegate;
        this.panel = panel;
    }

    @Override
    public <T> T getValue(String value, Class<T> type) {
        return delegate.getValue(value, type);
    }

    @Override
    public void setValue(String value, Object object) {
        delegate.setValue(value, object);
    }

    @Override
    public <T> T getProperty(Class<T> property) {

        if (property.isInstance(panel)) {
            return (T) panel;
        }

        return delegate.getProperty(property);
    }
}
