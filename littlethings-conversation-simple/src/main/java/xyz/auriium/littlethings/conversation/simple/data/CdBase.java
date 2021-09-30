package xyz.auriium.littlethings.conversation.simple.data;

import xyz.auriium.littlethings.conversation.ConversationData;

import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CdBase implements ConversationData {

    private final ConcurrentMap<String, Object> map = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getValue(String value, Class<T> type) {

        Object object = map.get(value);

        if (object == null) throw new NoSuchElementException("Missing element for value " + value);
        if (!type.isInstance(object)) throw new IllegalStateException("Value is not of correct type!");

        return (T) object;
    }

    @Override
    public void setValue(String value, Object object) {
        map.put(value, object);
    }

    @Override
    public <T> T getProperty(Class<T> property) {
        throw new NoSuchElementException("Default conversation data has no properties");
    }
}
