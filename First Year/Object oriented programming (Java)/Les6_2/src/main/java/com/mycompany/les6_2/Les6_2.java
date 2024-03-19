package com.mycompany.les6_2;
import java.util.Scanner;

public class Les6_2 {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        int [] arr = new int[5];
        arr[0] = 5;
        arr[1] = 10;
        arr[2] = 15;
        arr[3] = 20;
        arr[4] = 25;
        
        int [] arr2 = arr;
        arr2[4] = 30;
        System.out.println(arr2[4]);
        System.out.println(arr[4]);
        
        int l = arr.length;
        System.out.println("Size of array" + l);
        
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        
        int size = s.nextInt();
        
        int[] newArr = new int[size];
        
        for (int i = 0; i < size; i++) {
            System.out.println("Enter " + (i + 1) + " element");
            newArr[i] = s.nextInt();
        }
        
        
    }
}
