package com.lq.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lq
 * @date 2020-06-13 22:05
 */
public class TimeLock implements Runnable {
    
    public static ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getId() + "获取到锁");
                System.out.println("持有锁，休眠6秒");
                Thread.sleep(6000);
            } else {
                System.out.println(Thread.currentThread().getId() + "获取锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if( lock.isHeldByCurrentThread() ) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeLock timeLock = new TimeLock();
        Thread t1 = new Thread(timeLock);
        Thread t2 = new Thread(timeLock);
        t1.start();
        t2.start();
    }
}
