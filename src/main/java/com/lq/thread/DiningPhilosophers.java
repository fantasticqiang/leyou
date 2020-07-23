package com.lq.thread;

import java.util.concurrent.Semaphore;

/**
 * @author lq
 * @date 2020-06-08 16:05
 */
public class DiningPhilosophers {

    public static void main(String[] args) {
        int n = 1;
        DiningPhilosophers d = new DiningPhilosophers();
        new Thread(() -> {
            for (int i = 0; i < n; i++) {
                try {
                    d.wantsToEat(0, () -> {
                        System.out.println("哲学家" + 0 + "拿起" + 0);
                    }, () -> {
                        System.out.println("哲学家" + 0 + "拿起" + 1);
                    }, () -> {
                        System.out.println("哲学家" + 0 + "吃" + 0);
                    }, () -> {
                        System.out.println("哲学家" + 0 + "放下" + 0);
                    }, () -> {
                        System.out.println("哲学家" + 0 + "放下" + 1);
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < n; i++) {
                try {
                    d.wantsToEat(1, () -> {
                        System.out.println("哲学家" + 1 + "拿起" + 1);
                    }, () -> {
                        System.out.println("哲学家" + 1 + "拿起" + 2);
                    }, () -> {
                        System.out.println("哲学家" + 1 + "吃" + 1);
                    }, () -> {
                        System.out.println("哲学家" + 1 + "放下" + 1);
                    }, () -> {
                        System.out.println("哲学家" + 1 + "放下" + 2);
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < n; i++) {
                try {
                    d.wantsToEat(2, () -> {
                        System.out.println("哲学家" + 2 + "拿起" + 2);
                    }, () -> {
                        System.out.println("哲学家" + 2 + "拿起" + 3);
                    }, () -> {
                        System.out.println("哲学家" + 2 + "吃" + 2);
                    }, () -> {
                        System.out.println("哲学家" + 2 + "放下" + 2);
                    }, () -> {
                        System.out.println("哲学家" + 2 + "放下" + 3);
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < n; i++) {
                try {
                    d.wantsToEat(3, () -> {
                        System.out.println("哲学家" + 3 + "拿起" + 3);
                    }, () -> {
                        System.out.println("哲学家" + 3 + "拿起" + 4);
                    }, () -> {
                        System.out.println("哲学家" + 3 + "吃" + 3);
                    }, () -> {
                        System.out.println("哲学家" + 3 + "放下" + 3);
                    }, () -> {
                        System.out.println("哲学家" + 3 + "放下" + 4);
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < n; i++) {
                try {
                    d.wantsToEat(4, () -> {
                        System.out.println("哲学家" + 4 + "拿起" + 4);
                    }, () -> {
                        System.out.println("哲学家" + 4 + "拿起" + 0);
                    }, () -> {
                        System.out.println("哲学家" + 4 + "吃" + 4);
                    }, () -> {
                        System.out.println("哲学家" + 4 + "放下" + 4);
                    }, () -> {
                        System.out.println("哲学家" + 4 + "放下" + 0);
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    Semaphore[] forks = {new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1)};
    Semaphore maxFour = new Semaphore(4);

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        while (true) {
            maxFour.acquire();
            Semaphore forkLeft = forks[philosopher];
            Semaphore forkRight = forks[(philosopher + 1) % 5];
            if (forkLeft.tryAcquire()) {
                pickLeftFork.run();
                if (forkRight.tryAcquire()) {
                    pickRightFork.run();
                    eat.run();
                    putLeftFork.run();
                    pickRightFork.run();
                    break;
                } else {
                    forkLeft.release();
                    putLeftFork.run();
                }
            } else {
                if (forkRight.tryAcquire()) {
                    pickRightFork.run();
                    if (forkLeft.tryAcquire()) {
                        pickLeftFork.run();
                        eat.run();
                        putLeftFork.run();
                        putRightFork.run();
                        break;
                    }
                } else {
                    forkRight.release();
                    putRightFork.run();
                }
            }

            maxFour.release();
        }

    }


}
