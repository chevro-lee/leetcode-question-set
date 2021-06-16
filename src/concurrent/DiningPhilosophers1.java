package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author li.ling
 * Description 哲学家进餐问题，加锁顺序，偶数位哲学家先拿左边的叉，奇数位哲学家先拿右边的叉
 * Date 2021/3/1 9:20
 */
public class DiningPhilosophers1 {

    private Lock[] forks = new ReentrantLock[5];

    public DiningPhilosophers1() {
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
        if (philosopher % 2 == 0) {
            forks[leftFork].lock();
            forks[rightFork].lock();
        } else {
            forks[rightFork].lock();
            forks[leftFork].lock();
        }
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        forks[leftFork].unlock();
        forks[rightFork].unlock();
    }
}
