package com.qing;


class Sync {
    public void test() {
        synchronized (this) {
            System.out.println("test方法开始，当前线程为 " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test方法结束，当前线程为 " + Thread.currentThread().getName());
        }
    }
}

class MyThread4 extends Thread {
    private Sync sync;

    public MyThread4(Sync sync) {
        this.sync = sync;
    }

    @Override
    public void run() {
        this.sync.test();
    }
}

public class Test3 {
    public static void main(String[] args) {
        Sync sync = new Sync();
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread4(sync);
            thread.start();
        }
    }
}

