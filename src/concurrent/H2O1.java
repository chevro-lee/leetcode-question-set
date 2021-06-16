package concurrent;

import java.util.concurrent.*;

/**
 * Author li.ling
 * Description
 * Date 2021/2/25 17:03
 */
public class H2O1 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(12);

    private CyclicBarrier cyclicBarrier;
    private Semaphore semaphoreHyg;
    private Semaphore semaphoreOyg;

    public H2O1() {
        cyclicBarrier = new CyclicBarrier(3);
        semaphoreHyg = new Semaphore(2);
        semaphoreOyg = new Semaphore(1);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreHyg.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        semaphoreHyg.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreOyg.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        semaphoreOyg.release();
    }

    public static void main(String[] args) {
        H2O1 h2o = new H2O1();
        for (char c : "OHHOOOHOHHHHHHH".toCharArray()) {
            executorService.execute(()->{
                try {
                    if (c == 'O') {
                        h2o.oxygen(()-> System.out.print('O'));
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
