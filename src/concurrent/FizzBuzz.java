package concurrent;

import java.util.function.IntConsumer;

/**
 * Author li.ling
 * Description 能被3整除输出fizz，被5整除输出buzz，同时被3和5整除，输出fizzbuzz
 * 例如：输入n当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz
 * 实现一个多线程版的fizzbuzz
 * Date 2021/2/26 14:27
 */
public class FizzBuzz {

    private int n;

    private volatile int step;

    public FizzBuzz(int n) {
        this.n = n;
        this.step = 0;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i = i + 3) {
            if (i % 15 == 0) {
                continue;
            }
            while (step != 2) {
                Thread.yield();
            }
            printFizz.run();
            step = 0;
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i = i + 5) {
            if (i % 15 == 0) {
                continue;
            }
            while (step != 3) {
                Thread.yield();
            }
            printBuzz.run();
            step = 0;
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i = i + 15) {
            while (step != 1) {
                Thread.yield();
            }
            printFizzBuzz.run();
            step = 0;
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (step != 0) {
                Thread.yield();
            }
            if (i % 3 == 0 && i % 5 == 0) {
                step = 1;
            } else if (i % 3 == 0) {
                step = 2;
            } else if (i % 5 == 0) {
                step = 3;
            } else {
                printNumber.accept(i);
                step = 0;
            }
        }
    }

}
