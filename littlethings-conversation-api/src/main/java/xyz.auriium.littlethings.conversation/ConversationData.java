package xyz.auriium.littlethings.conversation;

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
     * Sets a value
     * @param value the identifier of the value
     * @param object the object to set
     */
    void setValue(String value, Object object);

    /**
     * Gets a property from a data
     * @param property the property
     * @param <T> type of property
     * @return the property
     * @throws java.util.NoSuchElementException if not present
     */
    <T> T getProperty(Class<T> property);

}
