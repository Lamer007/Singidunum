package com.mycompany.les8;

public abstract class Robot {
    private double mass;
    private String name, password;

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Robot(double mass, String name, String password) {
        this.mass = mass;
        this.name = name;
        this.password = password;
    }
    
    abstract protected void exOfCommand(String command);
}
