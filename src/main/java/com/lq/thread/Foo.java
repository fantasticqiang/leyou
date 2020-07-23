package com.lq.thread;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lq
 * @date 2020-06-07 17:00
 */
public class Foo {

    public static void main(String[] args) {
        Foo foo = new Foo();
        threadOne threadOne = new threadOne();
        threadTwo threadTwo = new threadTwo();
        threadThree threadThree = new threadThree();
         new Thread(threadOne).start();
         new Thread(threadTwo).start();
         new Thread(threadThree).start();

    }

    private AtomicInteger count = new AtomicInteger(1);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (Foo.class) {
            while (count.get() % 3 != 1) {

            }
            printFirst.run();
            count.set(count.get() + 1);
        }
        // printFirst.run() outputs "first". Do not change or remove this line.

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (Foo.class) {
            while (count.get() % 3 != 2) {

            }
            printSecond.run();
            count.set(count.get() + 1);
        }
        // printSecond.run() outputs "second". Do not change or remove this line.

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (Foo.class) {
            while (count.get() % 3 != 0) {

            }
            printThird.run();
            count.set(count.get() + 1);
        }
            // printThird.run() outputs "third". Do not change or remove this line.

    }

    static class threadOne implements Runnable {
        @Override
        public void run() {
            System.out.println("one");
        }
    }

    static class threadTwo implements Runnable {
        public threadTwo() {
        }

        @Override
        public void run() {
            System.out.println("two");
        }
    }

    static class threadThree implements Runnable {
        @Override
        public void run() {
            System.out.println("three");
        }
    }
}
