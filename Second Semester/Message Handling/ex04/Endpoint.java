package ex04;

public abstract class Endpoint {
    /**
     * Invoked when the endpoint is connected with the broker.
     *
     * @param session the session the broker created for this endpoint
     */
    protected abstract void onConnect(Session session);

    /**
     * Invoked when a message for this endpoint is received.
     *
     * @param sender  the name of the sender
     * @param message the message data
     */
    protected abstract void onMessage(String sender, Message message);

    /**
     * Invoked when the endpoint gets removed from the broker.
     */
    protected abstract void onClose();
}
