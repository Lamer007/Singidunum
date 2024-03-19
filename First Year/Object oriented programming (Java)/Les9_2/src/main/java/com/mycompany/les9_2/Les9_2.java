package com.mycompany.les9_2;

public class Les9_2 {

    public static void main(String[] args) {
        Bus b = new Bus(12, 2, "SomeBusCompany", "Budapes", "Belgrade");
        b.reservSeat();
        System.out.println(b + " The price is " + b.calcPrice());
        
    }
}
