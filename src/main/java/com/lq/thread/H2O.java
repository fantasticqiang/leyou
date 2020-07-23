package com.lq.thread;

import java.util.concurrent.Semaphore;

/**
 * @author lq
 * @date 2020-06-08 09:54
 */
public class H2O {

    public static void main(String[] args) throws InterruptedException {
        H2O h2O = new H2O();
        int n = 5;
        new Thread(() -> {
            for (int i = 0; i < n; i++) {
                try {
                    h2O.hydrogen(() -> {
                        System.out.println("H");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < n; i++) {
                try {
                    h2O.hydrogen(() -> {
                        System.out.println("H");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < n; i++) {
                try {
                    h2O.oxygen(() -> {
                        System.out.println("O");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    Semaphore semaphoreH = new Semaphore(2);
    Semaphore semaphoreO = new Semaphore(1);

    Semaphore semaphoreO2 = new Semaphore(0);
    Semaphore semaphoreH3 = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        semaphoreH.acquire();//消耗一个H
        semaphoreO2.release();//可以来氧气了
        semaphoreH3.acquire();//阻止第三个H
        releaseHydrogen.run();
        semaphoreH.release(); //唤醒一个H


    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {


        semaphoreO.acquire(); //一个O
        semaphoreH3.release(2);//可以来两个H
        semaphoreO2.acquire(2);//消耗两个氧气
        releaseOxygen.run();
        semaphoreO.release();


    }

}


