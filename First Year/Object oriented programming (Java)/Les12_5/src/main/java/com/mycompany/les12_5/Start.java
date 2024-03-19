package com.mycompany.les12_5;

class Warehouse {
    int noOfBricks;
    
    public void addBricks() {
        synchronized (this) {
        this.noOfBricks++;
        }
    }
    
    public int getNoBricks() {return this.noOfBricks;}
}

class Worker extends Thread {
    Warehouse wh = null;
    
    public Worker(Warehouse wh) {
        this.wh = wh;
    }
    
    public void run() {
        for(int i = 0; i < 500; i++) {
            wh.addBricks();
        }
    }
}

public class Start {

    public static void main(String[] args) throws InterruptedException{
        Warehouse wh = new Warehouse();
        Worker pera = new Worker(wh);
        Worker zika = new Worker(wh);
        
        pera.start();
        zika.start();
        
        Thread.sleep(400);
        System.out.println("No of bricks" + wh.getNoBricks());
    }
}
