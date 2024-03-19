package com.mycompany.les8;

public class CarRobot extends Robot {
    
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public CarRobot(double speed, double mass, String name, String password) {
        super(mass, name, password);
        this.speed = speed;
    }
    
    @Override
    protected void exOfCommand(String command) {
        if(command.equals("Move"))
        {
            System.out.println("I am moving");
        }
        else if(command.equals("Stop"))
        {
            System.out.println("I am moving");
        }
        else
        {
            System.out.println("Wrong answer");
        }
    }
    
}
