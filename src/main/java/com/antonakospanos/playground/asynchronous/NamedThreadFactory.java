package com.antonakospanos.playground.asynchronous;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by antonakospanos on 11/03/2018.
 */
public class NamedThreadFactory implements ThreadFactory {

    private final ThreadGroup group;
    private final String threadPrefix;
    private final AtomicInteger threadCounter = new AtomicInteger(1);

    public NamedThreadFactory(String threadPrefix) {
        SecurityManager s = System.getSecurityManager();
        this.group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.threadPrefix = threadPrefix;
    }

    @Override
    public Thread newThread(Runnable task) {
        int threadNumber = threadCounter.getAndIncrement();
        String threadName = threadPrefix + "-" + threadNumber;

        Thread thread = new Thread(group, task, threadName, 0, true);

        // Fix Thread Priority
        if (thread.getPriority() != Thread.NORM_PRIORITY) {
            thread.setPriority(Thread.NORM_PRIORITY);
        }
        // Fix Thread type
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }

        return thread;
    }
}
