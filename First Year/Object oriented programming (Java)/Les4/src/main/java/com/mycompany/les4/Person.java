package com.mycompany.les4;

public class Person {

    public String name;
    public String lastName;
    public String personId;
    public int birthYear;
    
    public void printData () {
        System.out.println("Info" + name + " " + lastName + " " + personId + " " + birthYear);    
    }
    
    public void checkIdNumber() {
        int counter = 0;
        
        if(personId.length() == 13)
        {
            for(int i = 0; i < personId.length(); i++)
            {
                if(Character.isDigit(personId.charAt(i)))
                {
                    counter++;
                }
            }
        }
        
        if(counter == 13)
        {
            System.out.println("Person id number is correct");
        }
        else
        {
            System.out.println("Person id number is incorrect");
        }
    }
    
    public Person() {}
    
    public Person(String name, String lastName, String personId, int birthYear) {
        this.name = name;
        this.lastName = lastName;
        this.personId = personId;
        this.birthYear = birthYear;
    }
    
}
