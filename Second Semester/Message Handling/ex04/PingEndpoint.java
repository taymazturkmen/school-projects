package ex04;

import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PingEndpoint extends Endpoint {
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    @Override
    protected void onConnect(Session session) {
        Timer timer = new Timer();
        Message message = new Message("", MessageType.Call, "ping");
        Runnable pingRunnable = new Runnable() {
            public void run() {
                session.broadcast(message);
            }
        };
        executor.scheduleAtFixedRate(pingRunnable, 0, 1, TimeUnit.SECONDS);

        
        
    }

    @Override
    protected void onMessage(String sender, Message message) {
        if (message.getType().equals(MessageType.Call)) {
            System.err.println("Programing mistake: Ping Endpoint is not supposed to receive a Call.");
        }
    }

    @Override
    public void onClose() {
    }
}
