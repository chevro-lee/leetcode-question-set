package concurrent;

import java.util.function.IntConsumer;

/**
 * Author li.ling
 * Description
 * Date 2021/2/25 10:02
 */
public class ZeroEvenOdd1 {

    private int n;

    private volatile int step;

    public ZeroEvenOdd1(int n) {
        this.n = n;
        this.step = 0;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (step != 0) {
                Thread.yield();
            }
            printNumber.accept(0);
            if (i % 2 != 1) {
                step = 2;
            } else {
                step = 1;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i + 2) {
            while (step != 2) {
                Thread.yield();
            }
            printNumber.accept(i);
            step = 0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {
            while (step != 1) {
                Thread.yield();
            }
            printNumber.accept(i);
            step = 0;
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd1 zeroEvenOdd = new ZeroEvenOdd1(5);
        new Thread(()->{
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
