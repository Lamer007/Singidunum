package com.mycompany.les2;
import java.util.Scanner;

public class Les2 {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        int balance = 50000;
        int option;
        int amount;
        
        do {
            option = s.nextInt();
            
            switch(option){
                case 1:
                    System.out.println("Your balance is" + balance);
                    break;
                case 2:
                    System.out.println("Enter amout of money");
                    amount = s.nextInt();
                    if(amount <= balance)
                    {
                        System.out.println("You took" + amount);
                        balance -= amount;
                        System.out.println("New balance is " + balance);
                    }
                    else {
                        System.out.println("You do not have enought money");
                    }
                    break;
                case 3:
                    System.out.println("Good bye");
                    break;
                default:
                    System.out.println("Wrong option");
                    
            }
            
        } while(option != 3);
        
        int firstNumber, secondNumber, thirdNumber;
        firstNumber = s.nextInt();
        secondNumber = s.nextInt();
        thirdNumber = s.nextInt();
        
        if(firstNumber >= secondNumber && firstNumber >= thirdNumber)
        {
            System.out.println("First one" + firstNumber);
        }
        else if (secondNumber >= firstNumber && secondNumber >= thirdNumber)
        {
            System.out.println("Second one" + secondNumber);
        }
        else
        {
            System.out.println("Third one" + thirdNumber);
        }
        
        double eurSell = 117.89;
        double eurBuy = 118.45;
        
        double usdSell = 108.45;
        double usdBuy = 109.8;
        
        int firstOption, secondOption, amount2;
        
        do{
            System.out.println("1. Buy");
            System.out.println("2. Sell");
            System.out.println("3. Exit");
            
            option = s.nextInt();
            
            switch(option)
            {
                case 1:
                    System.out.println("1. EUR");
                    System.out.println("2. USD");
                    secondOption = s.nextInt();
                    
                    System.out.println("Enter amount of money");
                    amount2 = s.nextInt();
                    
                    if(secondOption == 1)
                    {
                        System.out.println("Bill:" + (amount2 * eurBuy));
                        
                    }
                    else if(secondOption == 2){
                        System.out.println("Bill" + (amount2 * usdBuy));
                    }
                    else
                    {
                        System.out.println("Wrong answer");
                    }
                    break;
                     
                    
                    
            }
            
        } while(option != 3);
        
        int x = s.nextInt();
        
        while(x > 0){
            if(x % 2 == 0)
            {
                System.out.print(" " + x);
            }
            x--;
        }
        
        String name = "Aleksei";
        String id = "123456";
        String reg = "123-qwerty";
    }
}
