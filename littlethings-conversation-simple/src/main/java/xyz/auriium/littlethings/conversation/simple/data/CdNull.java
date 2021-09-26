package xyz.auriium.littlethings.conversation.simple.data;

import java.util.NoSuchElementException;

public class CdNull implements ConversationData {

    private final ConversationData delegate;

    public CdNull(ConversationData delegate) {
        this.delegate = delegate;
    }

    @Override
    public <T> T getValue(String value, Class<T> type) {

        try {
            return delegate.getValue(value, type);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public void setValue(String value, Object object) {
        delegate.setValue(value, object);
    }
}
