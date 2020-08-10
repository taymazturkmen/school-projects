package ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final Random rnd = new Random();

    private static final List<String> randomEndpoints = new ArrayList<>();
    private static int nextEndpointNumber = 0;

    /**
     * Randomly mutates the setting and creates Jobs.
     *
     * @param broker      the broker to add/remove endpoints to
     * @param jobEndpoint the endpoint for creating send jobs
     */
    public static void doRandomStuff(Broker broker, JobEndpoint jobEndpoint) {
        final int action = rnd.nextInt(100);
        if (action < 15) {
            final var epName = "Pong_" + (nextEndpointNumber++);
            final var ep = new PongEndpoint();
            ep.setBadGuy(rnd.nextBoolean());
            broker.addEndpoint(epName, ep);
            randomEndpoints.add(epName);
        } else if (action < 85) {
            if (!randomEndpoints.isEmpty()) {
                final var ep = randomEndpoints.get(rnd.nextInt(randomEndpoints.size()));
                for (int i = 0; i < 2 + rnd.nextInt(2); i++) {
                    jobEndpoint.createJob(ep, "hello");
                }
            }
        } else if (action < 90) {
            if (!randomEndpoints.isEmpty()) {
                final var ep = randomEndpoints.remove(rnd.nextInt(randomEndpoints.size()));
                broker.removeEndpoint(ep);
            }
        } else {
            if (!randomEndpoints.isEmpty()) {
                final var ep = randomEndpoints.get(rnd.nextInt(randomEndpoints.size()));
                if (broker.addEndpoint(ep, new PongEndpoint()))
                    System.err.println("Programming mistake! Registered endpoint names must be unique");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final var broker = new Broker();
        final var jobEndpoint = new JobEndpoint();
        broker.addEndpoint("Job", jobEndpoint);
        broker.addEndpoint("Ping", new PingEndpoint());

        for (int i = 0; i < 800; i++) {
            doRandomStuff(broker, jobEndpoint);
            TimeUnit.MILLISECONDS.sleep(250);
        }

        for (var ep : randomEndpoints)
            broker.removeEndpoint(ep);
        broker.removeEndpoint("Job");
        broker.removeEndpoint("Ping");
        broker.shutdown();
    }

}
