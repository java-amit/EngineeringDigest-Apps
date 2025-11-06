package com.engineeringdigest.threadpool_executors_framework_14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/*ExecutorService
 * submit(), shutdown(), invokeAll()
 * Purpose: It Adds features for managing and controlling the execution of asynchronous tasks.
 * Can submit both Runnable and Callable tasks, and provides lifecycle control (shutdown, await termination, etc.).
 * */
public class ExecutorFrameWork {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });

        }
        executor.shutdown();
        // executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Total time " + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}