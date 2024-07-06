package examsim.threads.concurrency;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyRunnable {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            try {
                Instant before = Instant.now();
                TimeUnit.MILLISECONDS.sleep(300);
                Instant after = Instant.now();
                System.out.println("Time difference is: " + after.minus(before.getEpochSecond(), ChronoUnit.SECONDS).toEpochMilli());
                System.out.println("Ran after 300 milliseconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        executorService.execute(runnable);

        runnable.run();

    }
}
