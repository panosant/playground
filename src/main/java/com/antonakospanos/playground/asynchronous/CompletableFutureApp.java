package com.antonakospanos.playground.asynchronous;

import java.text.NumberFormat;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.UnaryOperator;

/**
 * Created by antonakospanos on 11/03/2018.
 */
public class CompletableFutureApp {

    private static ExecutorService executorService;

    public CompletableFutureApp(int threads) {
        this.executorService = Executors.newFixedThreadPool(threads, new NamedThreadFactory("completable-future"));
        // this.executorService = ForkJoinPool.commonPool() DEFAULT thread-pool of CompletableFuture Executor
    }

    UnaryOperator<Integer> task1 = (iteration) -> {
        System.out.println("Iteration " + iteration + ": Hello World 1 by " + Thread.currentThread().getName() + " thread!");

        return iteration;
    };

    UnaryOperator<Integer> task2 = (iteration) -> {
        long start = System.currentTimeMillis();

        // task of time complexity = 10 milliseconds
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        long diff = (end - start);
        System.out.println("Iteration " + iteration + ": Hello World 2 by " + Thread.currentThread().getName() + " thread! Computation: " + NumberFormat.getInstance().format(diff) + " milliseconds");

        return iteration;
    };

    UnaryOperator<Integer> task3 = (iteration) -> {
        System.out.println("Iteration " + iteration + ": Hello World 3 by " + Thread.currentThread().getName() + " thread!");

        return iteration;
    };


    /**
     * Tests J8 Completable Future's method: thenRunAsync
     */
    protected class RunAsyncTasks implements IntConsumer {

        public void accept(int iteration) {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> iteration, executorService);
            CompletableFuture<Integer> future1 = future.thenApplyAsync(task1, executorService);
            CompletableFuture<Integer> future2 = future1.thenApplyAsync(task2, executorService);
            CompletableFuture<Integer> future3 = future2.thenApply(task3); // no need to run again async: It's the final task of the completable future pipeline
            // runAfterBoth(future, Runnable) is a CompletionStage promise that the RUNNABLE task will be executed after the completion of two previous (future) tasks
            // thenCombine(future, BiFunction) is another CompletionStage promise that the BI-FUNCTION task will be executed after the completion of two previous (future) tasks

            System.out.println("Iteration " + iteration + ". Hello World by " + Thread.currentThread().getName() + " thread!");
        }
    }

    /**
     * Tests J8 Completable Future's method: thenRun and wait in the end the completion of all tasks (Future.get())
     */
    protected class RunSyncTasks implements IntConsumer {

        public void accept(int iteration) {

            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> iteration, executorService);
            CompletableFuture<Integer> future1 = future.thenApply(task1);
            CompletableFuture<Integer> future2 = future1.thenApply(task2);
            CompletableFuture<Integer> future3 = future2.thenApply(task3);

            System.out.println("Iteration " + iteration + ". Hello World by " + Thread.currentThread().getName() + " thread!");

            while (!future1.isDone() || !future2.isDone() || !future3.isDone()) {
                continue;
            }
//            try {
//                future.get();
//                future2.get();
//                future3.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
        }
    }
}