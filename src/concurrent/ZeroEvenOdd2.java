package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * Author li.ling
 * Description
 * Date 2021/2/25 10:36
 */
public class ZeroEvenOdd2 {

    private int n;

    private volatile int step = 0;

    private Lock lock = new ReentrantLock();
    private Condition conditionZero = lock.newCondition();
    private Condition conditionEven = lock.newCondition();
    private Condition conditionOdd = lock.newCondition();

    public ZeroEvenOdd2(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            try {
                lock.lock();
                if (step != 0) {
                    conditionZero.await();
                }
                printNumber.accept(0);
                if (i % 2 != 1) {
                    step = 2;
                    conditionEven.signal();
                } else {
                    step = 1;
                    conditionOdd.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i + 2) {
            try {
                lock.lock();
                if (step != 2) {
                    conditionEven.await();
                }
                printNumber.accept(i);
                step = 0;
                conditionZero.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {
            try {
                lock.lock();
                if (step != 1) {
                    conditionOdd.await();
                }
                printNumber.accept(i);
                step = 0;
                conditionZero.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd2 zeroEvenOdd = new ZeroEvenOdd2(5);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
