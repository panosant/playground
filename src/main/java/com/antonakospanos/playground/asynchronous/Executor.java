package com.antonakospanos.playground.asynchronous;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * Created by antonakospanos on 11/03/2018.
 */
public class Executor {

    public static void main(String[] args) throws InterruptedException {
        int threads = 100;
        int iterations = 100;

        execute(new CompletableFutureApp(threads).new RunAsyncTasks(), iterations);
        Thread.sleep(1000);
        execute(new CompletableFutureApp(threads).new RunSyncTasks(), iterations);
    }

    /**
     * Runs the passed task as many times as requested
     *
     * @param task
     * @param iterations
     */
    private static void execute(IntConsumer task, int iterations) {
        new TaskExecutor(iterations).accept(task);
    }

    /**
     *  Tests J8 Completable Future's method: thenRunAsync
     */
    public static class TaskExecutor implements TaskConsumer {

        private static int iterations;
        private static BigInteger avgTime = BigInteger.valueOf(0);

        public TaskExecutor(int iterations) {
            this.iterations = iterations;
        }

        public void accept(IntConsumer task) {
            IntStream.rangeClosed(1, iterations)
                    // .parallel()
                    .forEach((i) -> execute(task, i));

            System.out.println("*********** Average Computation: " + NumberFormat.getInstance().format(avgTime.divide(BigInteger.valueOf(iterations))) + " milliseconds");
        }

        private void execute(IntConsumer task, int iteration) {
            System.out.println("\n*********** Starting iteration " + iteration+ " ***********") ;
            long start = System.currentTimeMillis();

            task.accept(iteration); // Task executed by main thread

            long end = System.currentTimeMillis();
            long diff = (end - start);
            avgTime = avgTime.add(BigInteger.valueOf(diff));
            System.out.println("*********** Finished iteration " + iteration + " *********** Computation: " + NumberFormat.getInstance().format(diff) + " milliseconds.\n");
        }

    }

    @FunctionalInterface
    public interface TaskConsumer {
        void accept(IntConsumer task);
    }
}
