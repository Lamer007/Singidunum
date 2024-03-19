package com.mycompany.les6;

public class Student {
    private String name;
    private String lastName;
    private int year;
    private double gpa;
    
    public Student(String name, String lastName, int year, double gpa) {
        this.name = name;
        this.lastName = lastName;
        this.year = year;
        this.gpa = gpa;
    }
    
    public void setName(String name){this.name = name;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void setYear(int year){this.year = year;}
    public void setGpa(double gpa){this.gpa = gpa;}
    
    public String getName(){return this.name;}
    public String getlastName(){return this.lastName;}
    public int getYear(){return this.year;}
    public double getGpa(){return this.gpa;}
}
