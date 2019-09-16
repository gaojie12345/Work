package com.qing;

class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            Thread.yield();
            System.out.println("当前线程：" + Thread.currentThread().getName() + " ,i = " + i);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
    }
}
