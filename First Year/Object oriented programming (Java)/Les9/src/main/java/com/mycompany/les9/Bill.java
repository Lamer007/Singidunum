package com.mycompany.les9;

public abstract class Bill {
    
    private String billNumber;

    public Bill(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getBillNumber() {
        return billNumber;
    }
    
    abstract public double calc();
    
    abstract public boolean checkBill();
    
}
