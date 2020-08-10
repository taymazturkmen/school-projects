package ex04;

import java.util.Objects;
import java.lang.System.*;

/**
 * Represents a session handle for communication.
 */
public class Session {

    private final long id;
    private final Broker broker;
    int count = 0;
    Object lock = new Object();

    /**
     * Creates a new session handle for the specified broker.
     *
     * @param broker the broker maintaining the session
     */
    public Session(Broker broker) {
        this.broker = broker;
        synchronized (lock) {
            count++;
            id = count;
        }
    }

    /**
     * Sends a message to a specific target.
     *
     * @param target the name of the endpoint the message shall be sent to
     * @param msg    the message data
     */
    public void send(String target, Message msg) {
        broker.send(this, target, msg);
    }

    /**
     * Sends a message to all other active participants.
     *
     * @param msg the message data
     */
    public void broadcast(Message msg) {
        broker.broadcast(this, msg);
    }

}
