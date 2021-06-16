package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author li.ling
 * Description leetcode 1226哲学家进餐问题 加锁顺序：让五个哲学家先拿左边的锁，后拿右边的锁
 * Date 2021/2/27 16:56
 */
public class DiningPhilosophers {

    private Lock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
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
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        forks[Math.min(leftFork, rightFork)].lock();
        forks[Math.max(leftFork, rightFork)].lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        forks[Math.min(leftFork, rightFork)].unlock();
        forks[Math.max(leftFork, rightFork)].unlock();
    }


}
