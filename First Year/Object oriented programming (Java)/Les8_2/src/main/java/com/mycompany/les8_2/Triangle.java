package com.mycompany.les8_2;

public class Triangle extends Shape implements MyInterface{
    private double a, b, c;

    public Triangle(double a, double b, double c, String name, String color) {
        super(name, color);
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public double area() {
        return Math.sqrt(circumferenc() - a) * (circumferenc() - b) * (circumferenc() - c);
    }
    
    @Override
    public double circumferenc(){
        return a + b + c;
    }
    
    @Override
    public String toString() {
        return "Triangle" + super.toString() + "sides: " + this.a + this.b + this.c;
    }
    
    @Override
    public void print() {
        toString();
    }
    
}
