package com.mycompany.preparing;

public class Ticket {
    private int adult, child;
    private String fromD, toD;

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public String getFromD() {
        return fromD;
    }

    public void setFromD(String fromD) {
        this.fromD = fromD;
    }

    public String getToD() {
        return toD;
    }

    public void setToD(String toD) {
        this.toD = toD;
    }

    
    public Ticket() {
        
    }
    
    public Ticket(int adult, int child, String fromD, String toD) {
        this.adult = adult;
        this.child = child;
        this.fromD = fromD;
        this.toD = toD;
    }
    
    
    
    public int price() {
        return (adult * 500) + (child * 250);
    }
}
