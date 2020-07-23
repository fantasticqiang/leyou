package com.lq.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lq on 2020/3/24.
 */
public class OrderPrintABC {

    private static Lock lock = new ReentrantLock();

    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    private static int count = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for(int i = 0; i < 10; i++) {
                    while (count % 3 != 0) {
                        A.await();
                    }
                    count++;
                    System.out.println("A");
                    B.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for(int i = 0; i < 10; i++) {
                    while (count % 3 != 1) {
                        B.await();
                    }
                    count++;
                    System.out.println("B");
                    C.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for(int i = 0; i < 10; i++) {
                    while (count % 3 != 2) {
                        C.await();
                    }
                    count++;
                    System.out.println("C");
                    A.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        ThreadC threadC = new ThreadC();
        threadA.start();
        threadB.start();
        threadC.start();
    }

}
