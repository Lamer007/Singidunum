package com.mycompany.les12_4;

class Counter {
    long count = 0;
    public void add(long value) {
        this.count += value;
    }
}


class CounterThread extends Thread {
    protected Counter counter = null;
    
    public CounterThread(Counter counter) {
        this.counter = counter;
    }
    
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            counter.add(i);
        }
    }
}

public class Start {

    public static void main(String[] args) throws InterruptedException{
        Counter counter = new Counter();
        Thread t1 = new CounterThread(counter);
        Thread t2 = new CounterThread(counter);
        
        t1.start();
        t2.start();
        
        Thread.sleep(2);
        System.out.println(counter.count);
    }
}
