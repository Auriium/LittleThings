package xyz.auriium.littlethings.conversation.simple.data;

public interface ConversationData {

    /**
     * Gets a value
     * @param value the value
     * @param type type
     * @param <T> type
     * @return a value
     * @throws java.util.NoSuchElementException if not present
     */
    <T> T getValue(String value, Class<T> type);

    void setValue(String value, Object object);

}
