package src.examsim.threads.concurrency;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Adder {
    private static long LIMIT = 1000000000;
    private static final int THREADS = 100;

    public static ForkJoinPool forkJoinPool = new ForkJoinPool(2);

    static class AdderTask extends RecursiveTask<Long> {

        long from, to;

        public AdderTask(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if ((to - from) <= LIMIT/THREADS) {
                System.out.println("In if");
                long localSum = 0;
                for(long i = from; i <= to; i++) {
                    localSum += i;
                }
                return localSum;
            }
            else {
                System.out.println("In else");
                long mid = (from + to) / 2;
                AdderTask first = new AdderTask(from, mid);
                AdderTask second = new AdderTask(mid + 1, to);
                first.fork();
                return second.compute() + first.join();
                /*INSERT*/
            }
        }
    }

    public static void main(String[] args) {
        byte b1 = (byte) (127 + 21);
        System.out.println(b1);
        ForkJoinPool pool = new ForkJoinPool(THREADS);
        long sum = pool.invoke(new AdderTask(1, LIMIT));
//        long add = 1000000000L*(1000000000 + 1) / 2;
//        System.out.printf("sum of the number from %d to %d is %d %n", 1, LIMIT, sum);
//        System.out.printf("sum of the number from %d to %d is %d %n", 1, LIMIT, add);
    }
}
