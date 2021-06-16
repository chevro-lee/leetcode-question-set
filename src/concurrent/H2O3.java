package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author li.ling
 * Description
 * Date 2021/2/26 10:11
 */
public class H2O3 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(12);

    private AtomicInteger step = new AtomicInteger(0);

    public H2O3() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (this) {
            while (step.get() == 2) {
                this.wait();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            step.getAndAdd(1);
            this.notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized(this) {
            while (step.get() == 0 || step.get() == 1) {
                this.wait();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            step.set(0);
            this.notifyAll();
        }
    }

    public static void main(String[] args) {
        H2O3 h2o = new H2O3();
        for (char c : "OHHOOOHOHHHHHHH".toCharArray()) {
            executorService.execute(() -> {
                try {
                    if (c == 'O') {
                        h2o.oxygen(() -> System.out.print('O'));
                    } else {
                        h2o.hydrogen(() -> System.out.print('H'));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
