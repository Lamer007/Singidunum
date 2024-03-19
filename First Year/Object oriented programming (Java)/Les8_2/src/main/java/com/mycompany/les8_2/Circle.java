package com.mycompany.les8_2;

public class Circle extends Shape implements MyInterface{
    private double r;

    public Circle(double r, String name, String color) {
        super(name, color);
        this.r = r;
    }
    
    @Override
    public double area() {
        return r * r * Math.PI;
    }
    
    @Override
    public double circumferenc(){
        return 2*r*Math.PI;
    }
    
    @Override
    public String toString() {
        return "Cicle" + super.toString() + " radius " + r;
    }
    
    @Override
    public void print() {
        toString();
    }
}
