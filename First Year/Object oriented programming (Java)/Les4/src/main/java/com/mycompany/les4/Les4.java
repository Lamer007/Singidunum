package com.mycompany.les4;

public class Les4 {

    public static void sayHello() {
        System.out.println("Hello");
    }
    
    public static int returnFive() {
        return 5;
    }
    
    
    public static void main(String[] args) {
        Person p1 = new Person();
        
        p1.name = "Aleksei";
        p1.lastName = "Moiseev";
        p1.personId = "1234567890";
        p1.birthYear = 2005;
        
        Person p2 = new Person("Alex", "Mois", "09877654321", 1998);
        
        p1.printData();
        p2.printData();
    }
}
