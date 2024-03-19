package com.mycompany.les8;

public class Les8 {

    public static void main(String[] args) {
        CarRobot c1 = new CarRobot(250.00, 100.00, "carRobot1", "pas1234");
        FlyingRobot f1 = new FlyingRobot(500.00, 2000.00, "FlyingRobot1", "ababa");
        
        c1.exOfCommand("Move");
        f1.exOfCommand("Fly");
    }
}
