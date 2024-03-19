package com.mycompany.les12_3;

class MyThread extends Thread {
    @Override
    public void run() {
            System.out.println("My thread is running");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("My runnable is running");
    }
}

public class Les12_3 {

    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread mt1 = new Thread(mr);
        mt1.start();
    }
}
