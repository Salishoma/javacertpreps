package src.examsim.threads.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyCallable {
    public static void main(String[] args) throws Exception {
        List<Callable<String>> callableTasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            callableTasks.add(callable(i));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String any = executorService.invokeAny(callableTasks);
        System.out.println("Invoking any");
        System.out.println(any);
        System.out.println("Invoking all");
        List<Future<String>> futureList = executorService.invokeAll(callableTasks);
        futureList.forEach(future -> {
            try {
                String s = future.get();
                System.out.println(s);
                executorService.shutdown();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
//        Future<String> submit = executorService.submit(callable);
//        String s = submit.get();
//        System.out.println(s);
//        System.out.println(callable.call());
    }

    private static Callable<String> callable(int taskNumber) {
        return () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "task's execution " + taskNumber;
        };
    }
}
