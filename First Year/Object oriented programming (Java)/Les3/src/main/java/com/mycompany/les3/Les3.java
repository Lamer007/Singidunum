package com.mycompany.les3;

import java.util.Scanner;

public class Les3 {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n;
        System.out.println("Enter the number: ");
        n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Cube of" + i + "is " + (i * i * i));
        }
        
        int a, b, c, smallest, temp;
        
        a = s.nextInt();
        b = s.nextInt();
        c = s.nextInt();
        
        temp = a < b ? a : b;
        smallest = c < temp ? c : temp;
        System.out.println("The smallest " + smallest);
        
        int numbers = 100;
        for (int i = 0; i <= numbers; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
        
        String name;
        
        name = s.nextLine();
        char cc = name.charAt(5);
        
        System.out.println("Fith character is: " + cc);
        
        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.charAt(i));
        }
        
        String studentID;
        
        System.out.println("Enter student id: ");
        studentID = s.nextLine();
        
        if(studentID.length() == 11)
        {
            for (int i = 0; i < studentID.length(); i++) {
                if(i == 4 && studentID.charAt(i) != '/')
                {
                    System.out.println("Error 1");
                } else if(Character.isDigit(studentID.charAt(i))) {
                    System.out.println("Error 2");
                }
                else
                {
                    System.out.println("Error 3");
                }
                    
                
            }
        }
        
    }
}
