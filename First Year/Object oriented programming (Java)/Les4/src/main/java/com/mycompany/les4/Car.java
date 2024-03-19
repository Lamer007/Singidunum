package com.mycompany.les4;

public class Car {

    public String brand, model, regNumber;
    int yearOfProd;
    
    public void printData () {
        System.out.println("Info" + brand + " " + model + " " + regNumber + " " + yearOfProd);    
    }
    
    public void checkRegNumber()
    {
        boolean check = false;
        
        if(this.regNumber.length() == 8)
        {
            if(Character.isLetter(regNumber.charAt(0)) && Character.isLetter(regNumber.charAt(0))) {
                if(Character.isLetter(regNumber.charAt(regNumber.length() - 1)) && Character.isLetter(regNumber.charAt(regNumber.length() - 2))){
                    for(int i = 2; i < regNumber.length() - 2; i++){
                        if(!Character.isDigit(regNumber.charAt(i))){
                            check = false;
                            break;
                        } else {
                            check = true;
                        }
                    }
                }
            }
        }
        
        if(check)
        {
            System.out.println("Correct");
        }
        else
        {
            System.out.println("Incorrect");
        }
    }
    
    public Car(){}
    
    public Car(String brand, String model, String regNumber, int yearOfProd) {
        this.brand = brand;
        this.model = model;
        this.regNumber = regNumber;
        this.yearOfProd = yearOfProd;
    }   
}
