package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * Author li.ling
 * Description
 * Date 2021/2/27 9:44
 */
public class FizzBuzz1 {

    private int n;
    private int step;

    private ReentrantLock lock = new ReentrantLock();
    private Condition fizzCondition = lock.newCondition();
    private Condition buzzCondition = lock.newCondition();
    private Condition fizzBuzzCondition = lock.newCondition();
    private Condition numCondition = lock.newCondition();

    public FizzBuzz1(int n) {
        this.n = n;
        this.step = 0;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i = i + 3) {
            if (i % 5 != 0) {
                try {
                    lock.lock();
                    if (step != 1) {
                        fizzCondition.await();
                    }
                    printFizz.run();
                    step = 0;
                    numCondition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i = i + 5) {
            if (i % 3 != 0) {
                try {
                    lock.lock();
                    if (step != 2) {
                        buzzCondition.await();
                    }
                    printBuzz.run();
                    step = 0;
                    numCondition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i = i + 15) {
            try {
                lock.lock();
                if (step != 3) {
                    fizzBuzzCondition.await();
                }
                printFizzBuzz.run();
                step = 0;
                numCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            try {
                lock.lock();
                if (step != 0) {
                    numCondition.await();
                }
                if (i % 3 == 0 && i % 5 == 0) {
                    step = 1;
                    fizzBuzzCondition.signal();
                } else if (i % 3 == 0) {
                    step = 2;
                    fizzCondition.signal();
                } else if (i % 5 == 0) {
                    step = 3;
                    buzzCondition.signal();
                } else {
                    printNumber.accept(i);
                    step = 0;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz1 pfb = new FizzBuzz1(15);
        Thread t1 = new Thread(() -> {
            try {
                pfb.fizz(() -> System.out.print("fizz,"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                pfb.buzz(() -> System.out.print("buzz,"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                pfb.fizzbuzz(() -> System.out.print("fizzbuzz,"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                pfb.number(value -> System.out.print(value + ","));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
