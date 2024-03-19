package com.mycompany.les8_2;

public abstract class Shape {
    private String name;
    private String color;
    
    public Shape() {
        name = "Shape";
        color = "Red";
    }

    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }
    
    @Override
    public String toString() {
        return "Name: " + this.name + " color:" + this.color;
    }
    
    public void changeColor(String color) {
        this.color = color;
    }
    
    abstract public double area();
    abstract public double circumferenc();
    
}
