package com.mycompany.les5;
import java.util.Scanner;

public class Calculator {

    double number1;
    double number2;
    
    public double add(double n1, double n2){
        return n1 + n2;
    }
    
    public double substreaction(double n1, double n2) {
        return n1 - n2;
    }
    
    public double multiplication(double n1, double n2) {
        return n1 * n2;
    }
    
    public double division(double n1, double n2) {
        if(n2 != 0)
        {
            return n1/n2;
        }
        else
        {
            return 0;
        }
    }
    
    public void printMenu () {
        int option;
        Scanner s = new Scanner(System.in);
        
        do{
            System.out.println("Enter option");
            System.out.println("1. Add");
            System.out.println("2. Substraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("0. Exit");
            
            option = s.nextInt();
            
            System.out.println("Enter number 1");
            number1 = s.nextDouble();
            System.out.println("Enter number 2");
            number2 = s.nextDouble();
            
            switch(option)
            {
                case 1:
                    System.out.println("Result is" + add(number1, number2));
                    break;
                case 2:
                    System.out.println("Result is" + substreaction(number1, number2));
                    break;
                case 3:
                    System.out.println("Result is" + multiplication(number1, number2));
                    break;
                case 4:
                    System.out.println("Result is" + division(number1, number2));
                    break;
                case 0:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Wrong option");
                    break;
            }
            
        }while(option != 0);
    }
    
    public Calculator() {}

    public Calculator(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }
    
    
}
