package com.qing;

class MyThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程：" + Thread.currentThread().getName() + " ,i = " + i);
        }
    }
}

public class Test1 {
    public static void main(String[] args) {
        MyThread1 mt = new MyThread1();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
    }
}