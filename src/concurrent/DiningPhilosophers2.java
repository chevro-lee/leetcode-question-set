package concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author li.ling
 * Description
 * Date 2021/3/1 9:40
 */
public class DiningPhilosophers2 {

    private Lock[] forks = new ReentrantLock[5];

    // 限制进餐的人数
    private Semaphore limit = new Semaphore(3);

    public DiningPhilosophers2() {
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        while (true) {
            limit.acquire();
            int leftFork = philosopher;
            int rightFork = (philosopher + 1) % 5;
            // 先获取左边的锁，再尝试获取右边的锁
            forks[leftFork].lock();
            if (forks[rightFork].tryLock()) {
                pickLeftFork.run();
                pickRightFork.run();
                eat.run();
                putLeftFork.run();
                putRightFork.run();
                forks[leftFork].unlock();
                forks[rightFork].unlock();
                limit.release();
                break;
            } else {
                // 如果右边的锁获取失败，则放开左边的锁
                forks[leftFork].unlock();
            }
            limit.release();
        }
    }
}
