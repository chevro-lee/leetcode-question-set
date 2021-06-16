package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Author li.ling
 * Description 多线程按序打印
 * Date 2021/2/23 11:11
 */
class Foo {

    private static CountDownLatch firstSecond = new CountDownLatch(1);
    private static CountDownLatch secondThird = new CountDownLatch(1);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstSecond.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        firstSecond.await();
        printSecond.run();
        secondThird.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        secondThird.await();
        printThird.run();
    }

    public static void main(String[] args) {
        try {
            Foo foo = new Foo();
            foo.first(() -> System.out.print("first"));
            foo.second(() -> System.out.print("second"));
            foo.third(() -> System.out.print("third"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}