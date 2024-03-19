package com.mycompany.les7_2;

public class Vehicle {
    private String brand, model, reg;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public Vehicle(String brand, String model, String reg) {
        this.brand = brand;
        this.model = model;
        this.reg = reg;
    }
    
    
}
