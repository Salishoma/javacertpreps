package src.examsim.threads.concurrency;

import java.util.concurrent.Semaphore;

public class MyBinarySemaphore {

    public void acquireAndReleasePermit() {
        if(false); else;
        Semaphore semaphore = new Semaphore(1);
        try {
            semaphore.acquire();
            System.out.println("availablePermits: " + semaphore.availablePermits());
            semaphore.acquire();
            System.out.println("availablePermits: " + semaphore.availablePermits());
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println("availablePermits: " + semaphore.availablePermits());
            semaphore.release();
            System.out.println("availablePermits: " + semaphore.availablePermits());
        }
    }

    public static void main(String[] args) {
        MyBinarySemaphore binarySemaphore = new MyBinarySemaphore();
        binarySemaphore.acquireAndReleasePermit();
    }

}
