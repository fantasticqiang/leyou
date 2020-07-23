package com.lq.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lq
 * @date 2020-06-07 22:39
 */
public class ZeroEvenOdd {

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        Thread thread1 = new Thread(new Thread1(zeroEvenOdd));
        Thread thread2 = new Thread(new Thread2(zeroEvenOdd));
        Thread thread3 = new Thread(new Thread3(zeroEvenOdd));
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private int n;

    private static Lock lock = new ReentrantLock();

    private static Condition z = lock.newCondition();
    private static Condition num = lock.newCondition();

    private volatile int index = 0;

    private volatile boolean zeroBoolean = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (index < n) {
            lock.lock();
            while (!zeroBoolean) {
                z.await();
            }
            printNumber.accept(0);
            zeroBoolean = false;
            num.signalAll();
            index++;
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            lock.lock();
            while (zeroBoolean || (index & 1) == 1) {
                num.await();
            }
            printNumber.accept(i);
            zeroBoolean = true;
            z.signal();
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            lock.lock();
            while (zeroBoolean || (index & 1) == 0) { // 偶数 或者 输出0操作
                num.await();
            }
            printNumber.accept(i);
            zeroBoolean = true;
            z.signal();
            lock.unlock();
        }
    }
}

class IntConsumer {

    public static void accept(Integer x) {
        System.out.println(x);
    }
}

class Thread1 implements Runnable {
    private ZeroEvenOdd zeroEvenOdd;

    public Thread1(ZeroEvenOdd zeroEvenOdd) {
        this.zeroEvenOdd = zeroEvenOdd;
    }

    @Override
    public void run() {
        try {
            this.zeroEvenOdd.zero(new IntConsumer());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread2 implements Runnable {
    private ZeroEvenOdd zeroEvenOdd;

    public Thread2(ZeroEvenOdd zeroEvenOdd) {
        this.zeroEvenOdd = zeroEvenOdd;
    }

    @Override
    public void run() {
        try {
            this.zeroEvenOdd.even(new IntConsumer());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread3 implements Runnable {
    private ZeroEvenOdd zeroEvenOdd;

    public Thread3(ZeroEvenOdd zeroEvenOdd) {
        this.zeroEvenOdd = zeroEvenOdd;
    }

    @Override
    public void run() {
        try {
            this.zeroEvenOdd.odd(new IntConsumer());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
