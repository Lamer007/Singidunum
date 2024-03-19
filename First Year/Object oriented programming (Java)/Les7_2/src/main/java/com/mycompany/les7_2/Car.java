package com.mycompany.les7_2;

public class Car extends Vehicle{
    private int basicPrice, engingePower, productionYear;
    
    public Car(int basicPrice,int engingePower,int productionYear, String brand, String model, String reg) {
        super(brand, model, reg);
        this.basicPrice = basicPrice;
        this.engingePower = engingePower;
        this.productionYear = productionYear;
    }
    
    public int price()
    {
        int priceCalc = basicPrice * 8;
        
        if(engingePower > 2000)
        {
            priceCalc = basicPrice * 12;
        }
        
        return priceCalc;
    }

    public int getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(int basicPrice) {
        this.basicPrice = basicPrice;
    }

    public int getEngingePower() {
        return engingePower;
    }

    public void setEngingePower(int engingePower) {
        this.engingePower = engingePower;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }
    
    
}
