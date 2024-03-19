package com.mycompany.les8;

public class FlyingRobot extends Robot {
    private double maxH;

    public FlyingRobot(double maxH, double mass, String name, String password) {
        super(mass, name, password);
        this.maxH = maxH;
    }
    
    public double getMaxH() {return this.maxH;}
    
    @Override
    protected void exOfCommand(String command) {
        switch(command) {
            case "Fly":
                System.out.println("I am flying");
                break;
            case "Land":
                System.out.println("I have landed");
                break;
            default:
                System.out.println("Wrong command");
        }
    }
}
