package com.mycompany.les9_2;

public class Bus extends Transportation implements Reservation{
    
    private int numberOfSeats, seatClass;

    public Bus(int numberOfSeats, int seatClass, String campanyName, String destination, String from) {
        super(campanyName, destination, from);
        this.numberOfSeats = numberOfSeats;
        this.seatClass = seatClass;
    }
    
    @Override
    public String toString()
    {
        return "Bus" + super.toString() + " has " + this.numberOfSeats + " of class" + this.seatClass;
    }
    
    @Override
    public double calcPrice() {
        return seatClass * 1000.00;
    } 
    
    @Override
    public void reservSeat() {
        if(numberOfSeats == 0)
        {
            System.out.println("Bus is full");
        }
        else
        {
            numberOfSeats--;
        }
    }
}
