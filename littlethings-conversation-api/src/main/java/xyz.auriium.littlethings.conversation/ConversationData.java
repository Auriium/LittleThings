package xyz.auriium.littlethings.conversation;

import java.util.List;
import java.util.Map;

public interface ConversationData {

    /**
     * Gets a value
     * @param value the identifier of the value
     * @param type type class
     * @param <T> the type of the class
     * @return value
     * @throws java.util.NoSuchElementException if not present
     */
    <T> T getValue(String value, Class<T> type);

    /**
     * Make an immutable copy of this and return it
     * @return an immutable copy of this
     */
    ConversationData immutable();

    /**
     * Make an immutable copy of this with the given functions applied
     * @param functions functions
     * @return the new data object
     */
    ConversationData remapped(List<RemapFunction> functions);

}
