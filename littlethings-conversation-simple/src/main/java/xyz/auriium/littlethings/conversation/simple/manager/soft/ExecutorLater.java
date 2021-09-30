package xyz.auriium.littlethings.conversation.simple.manager.soft;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorLater implements Executor {

    private final ScheduledExecutorService service;
    private final long duration;
    private final TimeUnit unit;

    public ExecutorLater(ScheduledExecutorService service, long duration, TimeUnit unit) {
        this.service = service;
        this.duration = duration;
        this.unit = unit;
    }

    @Override
    public void execute(Runnable command) {
        service.schedule(command, duration, unit);
    }
}
