package src.examsim.threads.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

public class CustomRecursiveAction extends RecursiveAction{

    private String workload = "";
    private static final int THRESHOLD = 4;

    private static Logger logger = Logger.getAnonymousLogger();

    public CustomRecursiveAction(String workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.length() > THRESHOLD) {
            ForkJoinTask.invokeAll(createSubtasks());
        } else {
            processing(workload);
        }
    }

    private void processing(String workload) {

        String result = workload.toUpperCase();
        logger.info("This result - (" + result + ") - was processed by "
                + Thread.currentThread().getName());
    }

    private List<CustomRecursiveAction> createSubtasks() {
        List<CustomRecursiveAction> subtasks = new ArrayList<>();

        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2);

        subtasks.add(new CustomRecursiveAction(partOne));
        subtasks.add(new CustomRecursiveAction(partTwo));
        return subtasks;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CustomRecursiveAction entertainmentLikeNeverBefore = new CustomRecursiveAction("EntertainmentLikeNeverBefore");
        forkJoinPool.invoke(entertainmentLikeNeverBefore);
    }
}
