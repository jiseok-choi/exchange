package assignment.exchange.domain.externalapi.runtime;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestTemplateExecutor implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Thread thread;

    public void startExecutor() {
        if (thread == null) {
            thread = new Thread(this, "RestTemplate thread for background task");
            thread.setDaemon(true);
        }

        if (!thread.isAlive()) {
            thread.start();
        }
        logger.warn("start Executor");
    }

    public void stopExecutor() {
        if (thread != null) {
            thread = null;
        }
    }

    @Override
    public void run() {

        logger.warn("RestTemplate Executor run");
        Thread currentThrad = Thread.currentThread();

        while (currentThrad == thread) {
            try {

                Thread.sleep(1000 * 10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
