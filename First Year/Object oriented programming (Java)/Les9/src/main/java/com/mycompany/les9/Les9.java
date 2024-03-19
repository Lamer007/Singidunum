package com.mycompany.les9;

public class Les9 {

    public static void main(String[] args) {
        InternetBill ib1 = new InternetBill("Zika", "InternetFAST", true, 2, "1601024343");
        InternetBill ib2 = new InternetBill("Ana", "veryFastInternet", true, 3, "2134354636");
        InternetBill ib3 = new InternetBill("Laza", "SlowInternet", false, 1, "12543645654");
        
        double max = -1;
        
        if(ib1.checkBill())
        {
            System.out.println(ib1.toString() + "\nPrice is " + ib1.calc());
            
            if(ib1.calc() > max)
            {
                max = ib1.calc();
            }
        }
        else
        {
            System.out.println("Internet bill 1 is not correct");
        }
        
        if(ib2.checkBill())
        {
            System.out.println(ib2.toString() + "\nPrice is " + ib2.calc());
            if(ib2.calc() > max)
            {
                max = ib2.calc();
            }
            else
            {
                System.out.println("Internet bill 2 is not correct");
            }
        }
        
        if(ib3.checkBill())
        {
            System.out.println(ib3.toString() + "\nPrice is " + ib3.calc());
            if(ib3.calc() > max)
            {
                max = ib3.calc();
            }
            else
            {
                System.out.println("Internet bill 3 is not correct");
            }
        }
        
        System.out.println("Most expensive bill is " + max);
    }
}
