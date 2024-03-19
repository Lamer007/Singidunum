package com.mycompany.les9_2;

public class Transportation {
    private String campanyName, destination, from;
    
    @Override
    public String toString() {
        return " company: " + this.campanyName + " goes from" + this.from + " to " + this.destination;
    }

    public Transportation(String campanyName, String destination, String from) {
        this.campanyName = campanyName;
        this.destination = destination;
        this.from = from;
    }
    
    
}
