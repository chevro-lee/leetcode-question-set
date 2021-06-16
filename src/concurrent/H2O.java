package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Author li.ling
 * Description 三三成组突破屏障，组合产生水分子，并且保证产生要在下一个水分子组合产生之前生成水分子
 * Date 2021/2/25 15:13
 */
public class H2O {

    private static ExecutorService executorService = Executors.newFixedThreadPool(12);

    private Semaphore semaphoreHyg;
    private Semaphore semaphoreOyg;

    public H2O() {
        semaphoreHyg = new Semaphore(2);
        semaphoreOyg = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreHyg.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        semaphoreOyg.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreOyg.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        semaphoreHyg.release(2);
    }

    public static void main(String[] args) {
        H2O h2o = new H2O();
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
