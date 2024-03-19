package com.mycompany.les7_3;
import java.util.regex.Pattern;

public class Person {
    private String name, lastName, personId;
    private int birthYear;

    public Person(String name, String lastName, String personId, int birthYear) {
        this.name = name;
        this.lastName = lastName;
        this.personId = personId;
        this.birthYear = birthYear;
    }
    
    public boolean checkId(String id) {
        if(Pattern.matches("[0-9][13]", id)){
            return true;
        }
        return false;
    }
    
    public void setPersonId(String personId) {
        if(checkId(personId)){
            this.personId = personId;
        }
        else
        {
            System.out.println("Wrong format for person id the default value is set");
            this.personId = "0000000000000";
        }
    }
    
    @Override
    public String toString() {
        return " [" + " name: " + name + " last name: " + lastName + "birth year: " + birthYear;
    }
}
