package ex04;

/**
 * Accepts send jobs for arbitrary messages to other endpoints. The purpose of
 * this endpoint is to accept a message job created with
 * {@link #createJob(String, String)} and send it asynchronously to the
 * receiver. To contract is, that messages SHALL be buffered until a previous
 * send job has been responded to. Other messages (like the ping message) SHALL
 * NOT be blocked or otherwise prevented from being delivered while this
 * endpoint is waiting for a response.
 */
public class JobEndpoint extends Endpoint {
    Message msg;
    Boolean responded = true;
    Boolean jobCreated = false;
    Session sessionHandle;
    int count = 0;

    /**
     * Creates a new send job.
     *
     * @param receiver the name of the endpoint the message shall be sent to
     * @param message  the message data
     */
    public void createJob(String receiver, String message) {
        if (responded == true) {
            msg = new Message("", MessageType.Call, message);
            sessionHandle.send(receiver, msg);
            responded = false;
        }

    }

    /**
     * Processes the send jobs.
     */
    public void process() {
    }

    @Override
    protected void onConnect(Session session) {
        sessionHandle = session;
    }

    @Override
    protected void onMessage(String sender, Message message) {
        responded = true;
    }

    @Override
    public void onClose() {
    }
}
