package examsim.threads.concurrency;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.*;

public class MyScheduledExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

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

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<String> schedule = executorService.schedule(callable(3), 1, TimeUnit.SECONDS);
        String s = schedule.get();
        System.out.println(s);

        ScheduledFuture<?> scheduleAtFixedRate = executorService.scheduleAtFixedRate(runnable, 2000, 500, TimeUnit.MILLISECONDS);

        scheduleAtFixedRate.get();

    }

    private static Callable<String> callable(int taskNumber) {
        return () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "task's execution " + taskNumber;
        };
    }
}
