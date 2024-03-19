package com.mycompany.les1;
import java.util.Scanner;

public class Les1 {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Aboba");
        
        // integers
        byte a; // 1 bite
        short b; // 2 bites
        int c; // 4 bites
        long d; // 8 bites
        
        // floats
        float e; // 4 bites
        double f; // 8 bites
        
        char g; // 2 bytes
        
        boolean h; // true/false
        
        System.out.println("Enter a value for var of type int");
        c = s.nextInt();
        System.out.println("Value of c is" + c);
        
         System.out.println("Enter a value for var of type float");
        e = s.nextFloat();
        System.out.println("Value of e is" + e);
        
        int num1 = 200;
        int num2 = 100;
        
        while(num1 > num2)
        {
            System.out.println(num1 - num2);
            num2 += 11;
        }
        
                
        do {
            System.out.println(num1 - num2);
            num2 += 11;
        }while(num1 > num2);
        
        String name;
        System.out.println("Enter your name");
        name = s.nextLine();
        System.out.println("Hello" + name);
        
        int imaginedNumber;
        int guessNumber;
        imaginedNumber = (int)(100*Math.random()) + 1; // range 1 - 100
        
        do {
            System.out.println("Guess the number");
            guessNumber = s.nextInt();
            
            if(guessNumber < imaginedNumber)
            {
                System.out.println("I image a greater number");
            }
            else if (guessNumber > imaginedNumber)
            {
                System.out.println("I image a greater number");
            }
            else
            {
                System.out.println("Correct");
            }
            
        } while(guessNumber != imaginedNumber);
        
    }
}
