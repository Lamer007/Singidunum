package com.mycompany.les7_3;

public class Student extends Person{
    private String studentID;

    public Student(String studentID, String name, String lastName, String personId, int birthYear) {
        super(name, lastName, personId, birthYear);
        this.studentID = studentID;
    }
    
    @Override
    public String toString() {
        return super.toString() + " student id: " + studentID + " ]";
    }
}
