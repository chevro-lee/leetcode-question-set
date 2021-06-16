package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author li.ling
 * Description
 * Date 2021/2/25 17:31
 */
public class H2O2 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(12);

    private int step = 0;

    private Lock lock = new ReentrantLock();
    private Condition conditionHyg = lock.newCondition();
    private Condition conditionOyg = lock.newCondition();

    public H2O2() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        try {
            lock.lock();
            while (step == 2) {
                conditionHyg.await();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            step++;
            conditionOyg.signal();
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try {
            lock.lock();
            while (step == 0 || step == 1) {
                conditionOyg.await();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            step = 0;
            conditionHyg.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        H2O2 h2o = new H2O2();
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
    }
}
