package ex04;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PongEndpoint extends Endpoint {

    private Session session;
    private ScheduledExecutorService executor;

    private boolean badGuy = false;
    private volatile boolean sanityCheck = false;

    public void setBadGuy(boolean badGuy) {
        this.badGuy = badGuy;
    }

    @Override
    protected void onConnect(Session session) {
        this.session = session;
        executor = Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    protected void onMessage(String sender, Message message) {
        if (message.getType().equals(MessageType.Call)) {
            if (message.getText().equals("ping")) {
                session.send(sender, new Message(message.getId(), MessageType.Response, "pong"));
            } else {
                if (badGuy) {
                    if (sanityCheck)
                        System.err.println("Programming mistake. JobEndpoint did not wait for response.");
                    sanityCheck = true;
                    executor.schedule(() -> {
                        sanityCheck = false;
                        session.send(sender, new Message(message.getId(), MessageType.Response, "delayed response"));
                    }, 500, TimeUnit.MILLISECONDS);
                } else {
                    session.send(sender, new Message(message.getId(), MessageType.Response, "response"));
                }
            }
        }
    }

    @Override
    public void onClose() {
        executor.shutdown();
        session = null;
    }
}
