package ex04;
import java.lang.System.*;

/**
 * Simple message payload.
 */
public class Message {

    private final String id;
    private final MessageType type;
    private final String text;

    /**
     * Creates a new message payload.
     * Each message must be uniquely identifiable.
     * If a message is used in a broadcast this means that each instance sent to
     * another participant has the same ID, but different messages have different IDs.
     *
     * @param id   a unique ID for this message
     * @param type the message type
     * @param text the message text
     */
    public Message(String id, MessageType type, String text) {
        this.id = id;
        this.type = type;
        this.text = text;
        id = String.valueOf(System.currentTimeMillis());
    }

    /**
     * Returns the unique message ID.
     *
     * @return the uuid
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the message text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Returns the message type.
     *
     * @return the type of this message
     */
    public MessageType getType() {
        return type;
    }
}
