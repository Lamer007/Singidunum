package com.mycompany.les12_2;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class Les12_2 {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("input.txt");
            Scanner s = new Scanner(fis);
            PrintWriter p = new PrintWriter("output.txt");
            
            while (s.hasNext())
            {
                int squarM = s.nextInt();
                int roooms = s.nextInt();
                int no = s.nextInt();
                String street = s.nextLine();
                Apartments a = new Apartments(squarM, roooms, no, street);
                p.println("Price for the apartmant in " + street + "no " + no + " is " + a.pirce() + "eur.");
            }
            
            p.flush();
            p.close();
            fis.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("There is no such file");
        }
        catch(IOException e) {
            System.out.println("Aboba");
        }
    }
}
