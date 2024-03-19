package com.mycompany.les7;
import java.util.Scanner;
import java.util.Arrays;

public class Les7 {
    
    static void equ_of_two_arrays(int[] arr1, int[] arr2)
    {
        boolean equel = true;
        
        if(arr1.length == arr2.length)
        {
            for(int i = 0; i < arr2.length; i++)
            {
                if(arr1[i] != arr2[i])
                {
                    equel = false;
                }
            } 
        }
        else
        {
            equel = false;
        }
        
        if(equel)
        {
            System.out.println("Two arrays are equal");
        }
        else
        {
            System.out.println("Two arrays are not equal");
        }
    }

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        int r, c;
        
        System.out.println("Enter the number of rows");
        r = s.nextInt();
        System.out.println("Enter the number of columns");
        c = s.nextInt();
        
        int matrix1[][] = new int[r][c];
        int matrix2[][] = new int[r][c];
        int sumMatrix[][] = new int[r][c];
        
        System.out.println("Input element of first matrix");
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                matrix1[i][j] = s.nextInt();
            }
        }
        
        System.out.println("Input element of second matrix");
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                matrix2[i][j] = s.nextInt();
            }
        }
        
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.println("Sum matrix is " + sumMatrix[i][j] + "\t");
            }
        }
        
        int [] arrr1 = {1,2,3,4,5};
        int [] arrr2 = {1,2,3,4,5};
        int [] arrr3 = {11,22,33,44,55};
        
        equ_of_two_arrays(arrr1, arrr2);
        equ_of_two_arrays(arrr1, arrr3);
        
        int min = Integer.MAX_VALUE;
        int second_min = Integer.MIN_VALUE;
        
        int [] arrrr = {123,443,54,23,43,53};
        
        for(int i = 0; i < arrrr.length; i++)
        {
            if(arrrr[i] == min)
            {
                second_min = min;
            }
            else if (arrrr[i] < min)
            {
                second_min = min;
                min = arrrr[i];
            }
            else if (arrrr[i] < second_min)
            {
                second_min = arrrr[i];
            }
        }
        
        System.out.println("Second min" + second_min);
        System.out.println("Array is" + Arrays.toString(arrrr));
    }
}
