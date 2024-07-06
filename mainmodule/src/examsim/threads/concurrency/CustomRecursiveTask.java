package examsim.threads.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer> {
    private final int[] arr;

    private static final int THRESHOLD = 20;

    public CustomRecursiveTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        if (arr.length > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks())
                    .stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        } else {
            return processing(arr);
        }
    }

    private Integer processing(int[] arr) {
        return Arrays.stream(arr)
                .filter(num -> num > 10 && num < 27)
                .map(num -> num * 10)
                .sum();
    }

    private Collection<CustomRecursiveTask> createSubtasks() {
        List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
        int length = arr.length;
        int mid = length / 2;
        dividedTasks.add(new CustomRecursiveTask(Arrays.copyOfRange(arr, 0, mid)));
        dividedTasks.add(new CustomRecursiveTask(Arrays.copyOfRange(arr, mid, length)));
        return dividedTasks;
    }

    public static void main(String[] args) {
        CustomRecursiveTask customRecursiveTask =
                new CustomRecursiveTask(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,
                28,29,30});
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer sum = forkJoinPool.invoke(customRecursiveTask);
        System.out.println("Sum: " + sum);
    }
}
