package xyz.auriium.littlethings.conversation.simple.data;

import xyz.auriium.littlethings.conversation.ConversationData;
import xyz.auriium.littlethings.conversation.RemapFunction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class CdImmutable implements ConversationData {

    private final Map<String, Object> immutableMap;

    public CdImmutable() {
        this.immutableMap = Map.of();
    }

    CdImmutable(Map<String, Object> immutableMap) {
        this.immutableMap = immutableMap;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getValue(String value, Class<T> type) {

        Object object = immutableMap.get(value);

        if (object == null) throw new NoSuchElementException("Missing element for value " + value);
        if (!type.isInstance(object)) throw new IllegalStateException("Value is not of correct type!");

        return (T) object;
    }

    @Override
    public ConversationData immutable() {
        return new CdImmutable(Map.copyOf(immutableMap));
    }

    @Override
    public ConversationData remapped(List<RemapFunction> functions) {

        Map<String,Object> map = new HashMap<>(immutableMap); //modifiable copy

        for (RemapFunction function : functions) {
            map.compute(function.identifier(), function);
        }

        return new CdImmutable(Map.copyOf(immutableMap));
    }


}
