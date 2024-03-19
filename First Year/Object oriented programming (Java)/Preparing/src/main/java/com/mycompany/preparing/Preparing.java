package com.mycompany.preparing;
import java.io.FileInputStream; 
import java.io.PrintWriter; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.util.Scanner; 
import java.util.ArrayList;


public class Preparing {

    public static void main(String[] args) {
        try{
            FileInputStream fis = new FileInputStream("input.txt"); 
            Scanner s = new Scanner(fis); 
            PrintWriter p = new PrintWriter("output.txt"); 
            
            while(s.hasNext()){                 
                int adults = s.nextInt();
                int children = s.nextInt();
                String fr = s.next();
                String to = s.next();
                Ticket t = new Ticket(adults, children, fr, to);
                p.println("From: " + fr + " To: " + to + " Price:" + t.price());
            }
            p.close();
            p.flush();
            fis.close();
            
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e) {
            System.out.println("Unknown error");
        }
        
    }
}
